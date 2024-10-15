package io.vbytsyuk.dnd.domain.core.tools

import io.vbytsyuk.dnd.domain.core.units.lb
import io.vbytsyuk.dnd.domain.core.units.silver

interface GamingSet: Tools {

    override val weight get() = 0.lb
    override val description get() = """
        If you are proficient with a gaming set, you can add your proficiency bonus to ability checks you make to 
        play a game with that set. Each type of gaming set requires a separate proficiency.
    """.trimIndent()
}

data object DiceSet : GamingSet {
    override val cost = 1.silver
}

data object PlayingCardSet : GamingSet {
    override val cost = 5.silver
}
