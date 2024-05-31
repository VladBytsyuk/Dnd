package io.vbytsyuk.dnd.core

import io.vbytsyuk.dnd.core.units.Level
import kotlin.math.max

@JvmInline
value class Hp(val value: Int) {
    init { require(value >= 0) }
    operator fun plus(other: Hp): Hp = Hp(this.value + other.value)
    operator fun plus(other: Int): Hp = Hp(this.value + other)
    override fun toString() = "hp=$value"
}

fun calculateMaximumHp(
    hpDice: HpDice,
    constitutionModifier: Modifier,
    level: Level,
) = calculateMaximumHp(
    hpBase = hpDice.hpBase,
    hpIncrement = hpDice.hpIncrement,
    constitutionModifier = constitutionModifier,
    level = level
)

fun calculateMaximumHp(
    hpBase: Hp,
    hpIncrement: Hp,
    constitutionModifier: Modifier,
    level: Level,
): Hp {
    val hpOn1stLevel = hpBase + constitutionModifier.value
    if (level.value == 1) return hpOn1stLevel

    var hp = hpOn1stLevel
    for (i in 2..level.value) {
        hp += hpIncrement + max(constitutionModifier.value, 1) * (i - 1)
    }
    return hp
}
