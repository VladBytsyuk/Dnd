package io.vbytsyuk.dnd.domain.tools

import io.vbytsyuk.dnd.domain.units.gold
import io.vbytsyuk.dnd.domain.units.lb

interface MusicalInstrument : Tools {
    override val description get() = """
        If you have proficiency with a given musical instrument, you can add your proficiency bonus to any ability 
        checks you make to play music with the instrument. A bard can use a musical instrument as a spellcasting focus. 
        Each type of musical instrument requires a separate proficiency.
    """.trimIndent()
}

data object Bagpipes : MusicalInstrument {
    override val cost = 30.gold
    override val weight = 6.lb
}
data object Drum : MusicalInstrument {
    override val cost = 6.gold
    override val weight = 3.lb
}
data object Dulcimer : MusicalInstrument {
    override val cost = 25.gold
    override val weight = 10.lb
}
data object Flute : MusicalInstrument {
    override val cost = 2.gold
    override val weight = 1.lb
}
data object Lute : MusicalInstrument {
    override val cost = 35.gold
    override val weight = 2.lb
}
data object Lyre : MusicalInstrument {
    override val cost = 30.gold
    override val weight = 2.lb
}
data object Horn : MusicalInstrument {
    override val cost = 3.gold
    override val weight = 2.lb
}
data object PanFlute : MusicalInstrument {
    override val cost = 12.gold
    override val weight = 2.lb
}
data object Shawm : MusicalInstrument {
    override val cost = 2.gold
    override val weight = 1.lb
}
data object Viol : MusicalInstrument {
    override val cost = 30.gold
    override val weight = 1.lb
}
