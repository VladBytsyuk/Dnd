package io.vbytsyuk.dnd.core.units

import io.vbytsyuk.dnd.core.character.Character

@JvmInline
value class Exp(val value: Int) {

    init { require(value >= 0) }

    override fun toString() = "xp=$value"

    operator fun plus(other: Exp) = Exp(this.value + other.value)

    fun lvl() = level

    @Suppress("MagicNumber")
    val level: Level
        get() = when {
        value < 300 -> 1.level
        value < 900 -> 2.level
        value < 2_700 -> 3.level
        value < 6_500 -> 4.level
        value < 14_000 -> 5.level
        value < 23_000 -> 6.level
        value < 34_000 -> 7.level
        value < 48_000 -> 8.level
        value < 64_000 -> 9.level
        value < 85_000 -> 10.level
        value < 100_000 -> 11.level
        value < 120_000 -> 12.level
        value < 140_000 -> 13.level
        value < 165_000 -> 14.level
        value < 195_000 -> 15.level
        value < 225_000 -> 16.level
        value < 265_000 -> 17.level
        value < 305_000 -> 18.level
        value < 355_000 -> 19.level
        else -> 20.level
    }
}

val Int.exp: Exp get() = Exp(this)

operator fun Character.plus(exp: Exp): Character = copy(exp = exp)
