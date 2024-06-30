package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.HpDice
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies

interface Class {
    val hpDice: HpDice
    val proficiencies: Proficiencies
}
