package io.vbytsyuk.dnd.core.tools

import io.vbytsyuk.dnd.core.units.Coins
import io.vbytsyuk.dnd.core.units.Weight
import io.vbytsyuk.dnd.core.units.gold
import io.vbytsyuk.dnd.core.units.lb

sealed class MusicalInstruments(cost: Coins, weight: Weight) : Tools(
    cost = cost,
    weight = weight,
    description = """
        If you have proficiency with a given musical instrument, you can add your proficiency bonus to any ability 
        checks you make to play music with the instrument. A bard can use a musical instrument as a spellcasting focus. 
        Each type of musical instrument requires a separate proficiency.
    """.trimIndent(),
)

data object Bagpipes : MusicalInstruments(cost = 30.gold, weight = 6.lb)
data object Drum : MusicalInstruments(cost = 6.gold, weight = 3.lb)
data object Dulcimer : MusicalInstruments(cost = 25.gold, weight = 10.lb)
data object Flute : MusicalInstruments(cost = 2.gold, weight = 1.lb)
data object Lute : MusicalInstruments(cost = 35.gold, weight = 2.lb)
data object Lyre : MusicalInstruments(cost = 30.gold, weight = 2.lb)
data object Horn : MusicalInstruments(cost = 3.gold, weight = 2.lb)
data object PanFlute : MusicalInstruments(cost = 12.gold, weight = 2.lb)
data object Shawm : MusicalInstruments(cost = 2.gold, weight = 1.lb)
data object Viol : MusicalInstruments(cost = 30.gold, weight = 1.lb)
