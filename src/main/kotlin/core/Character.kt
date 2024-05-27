package io.vbytsyuk.dnd.core

import io.vbytsyuk.dnd.core.`class`.Class
import io.vbytsyuk.dnd.core.proficiencies.calculateProficiencyBonus
import io.vbytsyuk.dnd.core.race.Race
import io.vbytsyuk.dnd.core.skills.Skill

data class Character(
    val name: String,
    val race: Race,
    val `class`: Class,
    val initialRawStatBlock: StatBlock,
    val level: Level,
) {

    val statBlock: StatBlock = initialRawStatBlock +
            race.bonusStatBlock
    
    val maxHp: Hp = calculateMaximumHp(
        hpDice = `class`.hpDice,
        constitutionModifier = statBlock.modifier(StatType.CON),
        level = level,
    )

    val proficiencyBonus: Modifier = calculateProficiencyBonus(level)

    val skills: Map<Skill, Modifier> = buildMap {
        Skill.skillsSet
            .filterNotNull()
            .forEach { skill -> this += skill to calculateSkillModifier(skill) }
    }

    private fun calculateSkillModifier(skill: Skill): Modifier {
        val modifierFromStatBlock = statBlock.modifier(skill.originStatType)
        return when {
            skill in `class`.proficiencies.skills.selected.list -> modifierFromStatBlock + proficiencyBonus
            else -> modifierFromStatBlock
        }
    }
}
