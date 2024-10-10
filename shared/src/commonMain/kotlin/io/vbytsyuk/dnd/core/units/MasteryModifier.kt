package io.vbytsyuk.dnd.core.units

import io.vbytsyuk.dnd.core.Modifier
import io.vbytsyuk.dnd.core.proficiencies.Mastery
import io.vbytsyuk.dnd.core.proficiencies.Mastery.COMPETENT
import io.vbytsyuk.dnd.core.proficiencies.Mastery.NONE
import io.vbytsyuk.dnd.core.proficiencies.Mastery.PROFICIENT

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
