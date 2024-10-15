package io.vbytsyuk.dnd.domain.units

import io.vbytsyuk.dnd.domain.Modifier
import io.vbytsyuk.dnd.domain.proficiencies.Mastery
import io.vbytsyuk.dnd.domain.proficiencies.Mastery.COMPETENT
import io.vbytsyuk.dnd.domain.proficiencies.Mastery.NONE
import io.vbytsyuk.dnd.domain.proficiencies.Mastery.PROFICIENT

data class MasteryModifier(val mastery: Mastery, val modifier: Modifier) {
    override fun toString(): String {
        val masteryString = when (mastery) {
            COMPETENT -> "**"
            PROFICIENT -> "*"
            NONE -> ""
        }
        return "${masteryString}($modifier)"
    }
}
