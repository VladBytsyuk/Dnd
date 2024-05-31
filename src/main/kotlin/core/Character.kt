package io.vbytsyuk.dnd.core

import io.vbytsyuk.dnd.core.`class`.Class
import io.vbytsyuk.dnd.core.equipment.Equipment
import io.vbytsyuk.dnd.core.proficiencies.Mastery
import io.vbytsyuk.dnd.core.proficiencies.calculateProficiencyBonus
import io.vbytsyuk.dnd.core.race.Race
import io.vbytsyuk.dnd.core.skills.Skill
import io.vbytsyuk.dnd.core.units.Hp
import io.vbytsyuk.dnd.core.units.Level
import io.vbytsyuk.dnd.core.units.calculateMaximumHp

data class Character(
    val name: String,
    val race: Race,
    val `class`: Class,
    val initialRawStatBlock: StatBlock,
    val level: Level,
    val temporaryHp: Hp = Hp(0),
    val equipment: Equipment,
) {

    val statBlock: StatBlock = initialRawStatBlock +
            race.bonusStatBlock
    
    val maxHp: Hp = calculateMaximumHp(
        hpDice = `class`.hpDice,
        constitutionModifier = statBlock.modifier(StatType.CON),
        level = level,
    )

    var hp: Hp = maxHp

    val proficiencyBonus: Modifier = calculateProficiencyBonus(level)

    private val skillsProficiencies: Map<Skill, Mastery> = buildMap {
        Skill.skills().forEach { skill ->
            val mastery = when {
                skill in `class`.proficiencies.skills.selected.list -> Mastery.PROFICIENT
                else -> Mastery.NONE
            }
            this += skill to mastery
        }
    }

    val skills: Map<Skill, Modifier> = buildMap {
        Skill.skills().forEach { skill -> this += skill to calculateSkillModifier(skill) }
    }

    private fun calculateSkillModifier(skill: Skill): Modifier {
        val modifierFromStatBlock = statBlock.modifier(skill.originStatType)
        val mastery = skillsProficiencies[skill]
        return when (mastery) {
            Mastery.COMPETENT -> modifierFromStatBlock + proficiencyBonus + proficiencyBonus
            Mastery.PROFICIENT -> modifierFromStatBlock + proficiencyBonus
            else -> modifierFromStatBlock
        }
    }
    
    private val savingThrowsProficiencies: Map<StatType, Mastery> = buildMap { 
        StatType.entries.forEach { stat ->
            val mastery = when {
                stat in `class`.proficiencies.savingThrows -> Mastery.PROFICIENT
                else -> Mastery.NONE
            }
            this += stat to mastery
        }
    }
    
    val savingThrows: Map<StatType, Modifier> = buildMap { 
        StatType.entries.forEach { stat -> this += stat to calculateSavingThrowModifier(stat) }
    }

    private fun calculateSavingThrowModifier(statType: StatType): Modifier {
        val modifierFromStatBlock = statBlock.modifier(statType)
        val mastery = savingThrowsProficiencies[statType]
        return when (mastery) {
            Mastery.COMPETENT -> modifierFromStatBlock + proficiencyBonus + proficiencyBonus
            Mastery.PROFICIENT -> modifierFromStatBlock + proficiencyBonus
            else -> modifierFromStatBlock
        }
    }

    val armorClass: StatValue get() {
        val dexterityModifier = statBlock.modifier(StatType.DEX)
        val equippedArmor = equipment.equippedArmor.firstOrNull()
        return when {
            equippedArmor != null -> equippedArmor.type.calculateAC(dexterityModifier)
            else -> 10 + dexterityModifier.value
        }
    }

    val initiative: Modifier get() = statBlock.modifier(StatType.DEX)
}
