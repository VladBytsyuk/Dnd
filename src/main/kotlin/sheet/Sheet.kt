package io.vbytsyuk.dnd.sheet

import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.character.*
import io.vbytsyuk.dnd.core.skills.Skill
import io.vbytsyuk.dnd.core.units.MasteryModifier

data class Sheet(
    val base: Base,
    val health: Health,
    val passive: Passive,
    val skills: Skills,
//    val proficiencies: Proficiencies,
    val equipment: Equipment,
) {

    data class Base(
        val name: String,
        val background: String,
        val race: String,
        val `class`: String,
        val subclass: String,
        val alignment: String,
        val level: Int,
        val exp: Int,
    )

    data class Health(
        val armorClass: Int,
        val currentHp: Int,
        val temporaryHp: Int,
        val maxHp: Int,
    )

    data class Passive(
        val initiative: Int,
        val speed: Int,
        val size: String,
        val darkVision: Int?,
        val passivePerception: Int,
    )

    data class Skills(
        val proficiencyBonus: Int,
        val strength: Data,
        val dexterity: Data,
        val constitution: Data,
        val intelligence: Data,
        val wisdom: Data,
        val charisma: Data,
    ) {

        data class Data(
            val value: Int,
            val modifier: Int,
            val savingThrow: MasteryModifier,
            val skills: Map<String, MasteryModifier>
        ) {

            override fun toString() = "$value($modifier), savingThrow = $savingThrow\t\t$skills"

            companion object {

                fun build(character: Character, type: StatType) = Data(
                    value = when (type) {
                        StatType.STR -> character.statBlock.strength
                        StatType.DEX -> character.statBlock.dexterity
                        StatType.CON -> character.statBlock.constitution
                        StatType.INT -> character.statBlock.intelligence
                        StatType.WIS -> character.statBlock.wisdom
                        StatType.CHA -> character.statBlock.charisma
                    },
                    modifier = character.statBlock.modifier(type).value,
                    savingThrow = character.savingThrows[type]!!,
                    skills = when (type) {
                        StatType.STR -> Skill.Strength.all
                        StatType.DEX -> Skill.Dexterity.all
                        StatType.CON -> Skill.Constitution.all
                        StatType.INT -> Skill.Intelligence.all
                        StatType.WIS -> Skill.Wisdom.all
                        StatType.CHA -> Skill.Charisma.all
                    }.map { it::class.simpleName.orEmpty() to character.skills[it]!! }.toMap()
                )
            }
        }

        override fun toString(): String = """
            Skills: Proficiency = $proficiencyBonus,
                STR = $strength
                DEX = $dexterity
                CON = $constitution
                INT = $intelligence
                WIS = $wisdom
                CHA = $charisma
        """.trimIndent()
    }

    data class Proficiencies(
        val armor: Armor,
        val weapon: String,
        val tools: String,
        val languages: List<String>,
    ) {

        data class Armor(
            val light: Boolean,
            val medium: Boolean,
            val heavy: Boolean,
            val shield: Boolean
        )
    }

    data class Equipment(
        val items: List<String>,
    )

    constructor(character: Character) : this(
        base = Base(
            name = character.name,
            background = character.background.toString(),
            race = character.race::class.simpleName.orEmpty(),
            `class` = character.`class`::class.simpleName.orEmpty(),
            subclass = character.`class`.subClass?.let { it::class.simpleName }.orEmpty(),
            alignment = character.alignment.toString(),
            level = character.level.value,
            exp = character.exp.value,
        ),
        health = Health(
            armorClass = character.armorClass.value,
            currentHp = character.maxHp.value,
            temporaryHp = 0,
            maxHp = character.maxHp.value,
        ),
        passive = Passive(
            initiative = character.initiative.modifier.value,
            speed = character.race.baseSpeed.value.feet.toInt(),
            size = character.race.size.name,
            darkVision = character.race.darkVision?.feet?.toInt(),
            passivePerception = character.passivePerception,
        ),
        skills = Skills(
            proficiencyBonus = character.proficiencyBonus.value,
            strength = Skills.Data.build(character, StatType.STR),
            dexterity = Skills.Data.build(character, StatType.DEX),
            constitution = Skills.Data.build(character, StatType.CON),
            intelligence = Skills.Data.build(character, StatType.INT),
            wisdom = Skills.Data.build(character, StatType.WIS),
            charisma = Skills.Data.build(character, StatType.CHA),
        ),
//        proficiencies = Proficiencies(
//            armor = Proficiencies.Armor(
//                light = character.proficiencies.armor.check(Armor.Type.Light),
//                medium = character.proficiencies.armor.check(Armor.Type.Medium),
//                heavy = character.proficiencies.armor.check(Armor.Type.Heavy),
//                shield = character.proficiencies.armor.check(Armor.Type.Shield),
//            ),
//            weapon = character.proficiencies.weapons.check(),
//            tools = character.proficiencies.tools.check(),
//            languages = character.proficiencies.languages.check(),
//        ),
        equipment = Equipment(
            items = character.equipment.toList().map { (item, data) ->
                "${item.name}${if (data.count == 1) "" else " (${data.count})"}${if (data.isEquipped) "*" else ""}"
            },
        )
    )
}
