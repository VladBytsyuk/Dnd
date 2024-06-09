package io.vbytsyuk.dnd.core.tools

import io.vbytsyuk.dnd.core.units.Coins
import io.vbytsyuk.dnd.core.units.lb
import io.vbytsyuk.dnd.core.units.silver

sealed class GamingSet(cost: Coins) : Tools(
    cost = cost,
    weight = 0.lb,
    description = """
        If you are proficient with a gaming set, you can add your proficiency bonus to ability checks you make to 
        play a game with that set. Each type of gaming set requires a separate proficiency.
    """.trimIndent(),
)

data object DiceSet : GamingSet(cost = 1.silver)
data object PlayingCardSet : GamingSet(cost = 5.silver)
