package io.vbytsyuk.dnd.sheet

import io.vbytsyuk.dnd.core.Modifier
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.character.*
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.skills.Skill
import io.vbytsyuk.dnd.core.units.Damage
import io.vbytsyuk.dnd.core.units.MasteryModifier
import io.vbytsyuk.dnd.core.units.Wallet
import io.vbytsyuk.dnd.core.units.damage
import io.vbytsyuk.dnd.core.weapon.Weapon
import jdk.jfr.Description

data class Sheet(
    val base: Base,
    val health: Health,
    val passive: Passive,
    val skills: Skills,
    val proficiencies: Proficiencies,
    val equipment: Equipment,
    val wallet: Wallet,
    val weaponsAttacks: List<Attack>,
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
        val initiative: Modifier,
        val speed: Int,
        val size: String,
        val darkVision: Int?,
        val passivePerception: Int,
    )

    data class Skills(
        val proficiencyBonus: Modifier,
        val strength: Data,
        val dexterity: Data,
        val constitution: Data,
        val intelligence: Data,
        val wisdom: Data,
        val charisma: Data,
    ) {

        data class Data(
            val value: Int,
            val modifier: Modifier,
            val savingThrow: MasteryModifier,
            val skills: Map<String, MasteryModifier>
        ) {
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
                    modifier = character.statBlock.modifier(type),
                    savingThrow = character.savingThrows[type]!!,
                    skills = when (type) {
                        StatType.STR -> Skill.Strength.all
                        StatType.DEX -> Skill.Dexterity.all
                        StatType.CON -> Skill.Constitution.all
                        StatType.INT -> Skill.Intelligence.all
                        StatType.WIS -> Skill.Wisdom.all
                        StatType.CHA -> Skill.Charisma.all
                    }.associate { it::class.simpleName.orEmpty() to character.skills[it]!! }
                )
            }
        }
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
            initiative = character.initiative.modifier,
            speed = character.race.baseSpeed.value.feet.toInt(),
            size = character.race.size.name,
            darkVision = character.race.darkVision?.feet?.toInt(),
            passivePerception = character.passivePerception,
        ),
        skills = Skills(
            proficiencyBonus = character.proficiencyBonus,
            strength = Skills.Data.build(character, StatType.STR),
            dexterity = Skills.Data.build(character, StatType.DEX),
            constitution = Skills.Data.build(character, StatType.CON),
            intelligence = Skills.Data.build(character, StatType.INT),
            wisdom = Skills.Data.build(character, StatType.WIS),
            charisma = Skills.Data.build(character, StatType.CHA),
        ),
        proficiencies = character.proficiencies,
        equipment = Equipment(
            items = character.equipment.toStringList()
        ),
        wallet = character.wallet,
        weaponsAttacks = character.equipment
            .mapNotNull { (item, data) ->
                if (!data.isEquipped) return@mapNotNull null
                val weapon = item as? Weapon ?: return@mapNotNull null
                val str = character.statBlock.modifier(StatType.STR)
                val dex = character.statBlock.modifier(StatType.DEX)
                val modifier = when {
                    weapon.rangeType == Weapon.RangeType.RANGED -> dex
                    weapon.isFinesse && dex > str -> dex
                    else -> str
                } + if (character.proficiencies.weapons.check(weapon)) character.proficiencyBonus else Modifier(0)
                val damage = if (character.proficiencies.weapons.check(weapon)) weapon.damage + modifier.value.damage(weapon.damage.entries.first().type) else weapon.damage
                Attack(
                    weapon = weapon,
                    modifier = modifier,
                    damage = damage,
                    description = "${weapon.name} attack",
                )
            }
    )

    data class Attack(
        val weapon: Weapon,
        val modifier: Modifier,
        val damage: Damage,
        val description: String,
    )
}
