package io.vbytsyuk.dnd.core.tools

import io.vbytsyuk.dnd.core.units.Coins
import io.vbytsyuk.dnd.core.units.Weight
import io.vbytsyuk.dnd.core.units.gold
import io.vbytsyuk.dnd.core.units.lb

sealed class MusicalInstrument(cost: Coins, weight: Weight) : Tools(
    cost = cost,
    weight = weight,
    description = """
        If you have proficiency with a given musical instrument, you can add your proficiency bonus to any ability 
        checks you make to play music with the instrument. A bard can use a musical instrument as a spellcasting focus. 
        Each type of musical instrument requires a separate proficiency.
    """.trimIndent(),
)

data object Bagpipes : MusicalInstrument(cost = 30.gold, weight = 6.lb)
data object Drum : MusicalInstrument(cost = 6.gold, weight = 3.lb)
data object Dulcimer : MusicalInstrument(cost = 25.gold, weight = 10.lb)
data object Flute : MusicalInstrument(cost = 2.gold, weight = 1.lb)
data object Lute : MusicalInstrument(cost = 35.gold, weight = 2.lb)
data object Lyre : MusicalInstrument(cost = 30.gold, weight = 2.lb)
data object Horn : MusicalInstrument(cost = 3.gold, weight = 2.lb)
data object PanFlute : MusicalInstrument(cost = 12.gold, weight = 2.lb)
data object Shawm : MusicalInstrument(cost = 2.gold, weight = 1.lb)
data object Viol : MusicalInstrument(cost = 30.gold, weight = 1.lb)
