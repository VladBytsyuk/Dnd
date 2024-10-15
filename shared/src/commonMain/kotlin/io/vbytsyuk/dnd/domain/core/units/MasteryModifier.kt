package io.vbytsyuk.dnd.domain.core.units

import io.vbytsyuk.dnd.domain.core.Modifier
import io.vbytsyuk.dnd.domain.core.proficiencies.Mastery
import io.vbytsyuk.dnd.domain.core.proficiencies.Mastery.COMPETENT
import io.vbytsyuk.dnd.domain.core.proficiencies.Mastery.NONE
import io.vbytsyuk.dnd.domain.core.proficiencies.Mastery.PROFICIENT

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
