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
        val strength: Data<Skill.Strength>,
        val dexterity: Data<Skill.Dexterity>,
        val constitution: Data<Skill.Constitution>,
        val intelligence: Data<Skill.Intelligence>,
        val wisdom: Data<Skill.Wisdom>,
        val charisma: Data<Skill.Charisma>,
    ) {

        data class Data<T : Skill>(
            val value: Int,
            val modifier: Int,
            val savingThrow: MasteryModifier,
            val skills: Map<T, MasteryModifier>
        ) {
        }
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
            strength = Skills.Data(
                value = character.statBlock.strength,
                modifier = character.statBlock.modifier(StatType.STR).value,
                savingThrow = character.savingThrows[StatType.STR]!!,
                skills = mapOf(
                    Skill.Strength.Athletics to character.skills[Skill.Strength.Athletics]!!
                )
            ),
            dexterity = Skills.Data(
                value = character.statBlock.dexterity,
                modifier = character.statBlock.modifier(StatType.DEX).value,
                savingThrow = character.savingThrows[StatType.DEX]!!,
                skills = mapOf(
                    Skill.Dexterity.Acrobatics to character.skills[Skill.Dexterity.Acrobatics]!!,
                    Skill.Dexterity.SleightOfHand to character.skills[Skill.Dexterity.SleightOfHand]!!,
                    Skill.Dexterity.Stealth to character.skills[Skill.Dexterity.Stealth]!!,
                )
            ),
            constitution = Skills.Data(
                value = character.statBlock.constitution,
                modifier = character.statBlock.modifier(StatType.CON).value,
                savingThrow = character.savingThrows[StatType.CON]!!,
                skills = emptyMap()
            ),
            intelligence = Skills.Data(
                value = character.statBlock.intelligence,
                modifier = character.statBlock.modifier(StatType.INT).value,
                savingThrow = character.savingThrows[StatType.INT]!!,
                skills = mapOf(
                    Skill.Intelligence.History to character.skills[Skill.Intelligence.History]!!,
                    Skill.Intelligence.Arcana to character.skills[Skill.Intelligence.Arcana]!!,
                    Skill.Intelligence.Nature to character.skills[Skill.Intelligence.Nature]!!,
                    Skill.Intelligence.Investigation to character.skills[Skill.Intelligence.Investigation]!!,
                    Skill.Intelligence.Religion to character.skills[Skill.Intelligence.Religion]!!,
                )
            ),
            wisdom = Skills.Data(
                value = character.statBlock.wisdom,
                modifier = character.statBlock.modifier(StatType.WIS).value,
                savingThrow = character.savingThrows[StatType.WIS]!!,
                skills = mapOf(
                    Skill.Wisdom.AnimalHandling to character.skills[Skill.Wisdom.AnimalHandling]!!,
                    Skill.Wisdom.Insight to character.skills[Skill.Wisdom.Insight]!!,
                    Skill.Wisdom.Medicine to character.skills[Skill.Wisdom.Medicine]!!,
                    Skill.Wisdom.Perception to character.skills[Skill.Wisdom.Perception]!!,
                    Skill.Wisdom.Survival to character.skills[Skill.Wisdom.Survival]!!,
                )
            ),
            charisma = Skills.Data(
                value = character.statBlock.charisma,
                modifier = character.statBlock.modifier(StatType.CHA).value,
                savingThrow = character.savingThrows[StatType.CHA]!!,
                skills = mapOf(
                    Skill.Charisma.Deception to character.skills[Skill.Charisma.Deception]!!,
                    Skill.Charisma.Intimidation to character.skills[Skill.Charisma.Intimidation]!!,
                    Skill.Charisma.Performance to character.skills[Skill.Charisma.Performance]!!,
                    Skill.Charisma.Persuasion to character.skills[Skill.Charisma.Persuasion]!!,
                )
            ),
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
