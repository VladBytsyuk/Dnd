package io.vbytsyuk.dnd.domain.character

import io.vbytsyuk.dnd.domain.proficiencies.Mastery.COMPETENT
import io.vbytsyuk.dnd.domain.proficiencies.Mastery.NONE
import io.vbytsyuk.dnd.domain.proficiencies.Mastery.PROFICIENT
import io.vbytsyuk.dnd.domain.skills.Skill
import io.vbytsyuk.dnd.domain.units.MasteryModifier

typealias SkillMap = Map<Skill, MasteryModifier>

val Character.skills: SkillMap
    get() = buildMap {
    Skill.all().filterNotNull().forEach { skill ->
        val mastery = when {
            skill in proficiencies.skills -> PROFICIENT
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
