package io.vbytsyuk.dnd.core.proficiencies

import io.vbytsyuk.dnd.core.Level
import io.vbytsyuk.dnd.core.Modifier
import kotlin.math.ceil

fun calculateProficiencyBonus(level: Level): Modifier =
    Modifier(ceil(level.value / 4.0).toInt() + 1)

fun calculateCanonicalProficiencyBonus(level: Level): Modifier = when (level.value) {
    in 1 .. 4 -> Modifier(2)
    in 5..8 -> Modifier(3)
    in 9..12 -> Modifier(4)
    in 13..16 -> Modifier(5)
    in 17..20 -> Modifier(6)
    else -> throw IllegalStateException("level should be in 1..20")
}
