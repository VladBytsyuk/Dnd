package io.vbytsyuk.dnd.core.character

import io.vbytsyuk.dnd.core.proficiencies.Mastery.*
import io.vbytsyuk.dnd.core.skills.Skill
import io.vbytsyuk.dnd.core.units.MasteryModifier

typealias SkillMap = Map<Skill, MasteryModifier>

val Character.skills: SkillMap get() = buildMap {
    val proficientSkillsList = `class`.proficiencies.skills.selected.list + race.proficiencies.skills.selected.list
    Skill.skills().forEach { skill ->
        val mastery = when {
            skill in proficientSkillsList -> PROFICIENT
            else -> NONE
        }
        val modifierFromStatBlock = statBlock.modifier(skill.originStatType)
        val modifier = when (mastery) {
            COMPETENT -> modifierFromStatBlock + proficiencyBonus + proficiencyBonus
            PROFICIENT -> modifierFromStatBlock + proficiencyBonus
            else -> modifierFromStatBlock
        }
        this += skill to MasteryModifier(mastery, modifier)
    }
}
