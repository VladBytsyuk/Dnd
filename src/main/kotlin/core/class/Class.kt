package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.HpDice
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies

sealed class Class(
    val hpDice: HpDice,
    val proficiencies: Proficiencies,
)
