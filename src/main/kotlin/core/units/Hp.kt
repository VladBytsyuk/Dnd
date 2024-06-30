package io.vbytsyuk.dnd.core.units

import io.vbytsyuk.dnd.core.HpDice
import io.vbytsyuk.dnd.core.Modifier
import kotlin.math.max

@JvmInline
value class Hp(val value: Int) {
    init { require(value >= 0) }

    operator fun plus(other: Hp): Hp = Hp(this.value + other.value)
    operator fun plus(other: Int): Hp = Hp(this.value + other)
    operator fun minus(other: Hp): Hp = Hp(max(0, this.value - other.value))
    operator fun minus(other: Int): Hp = Hp(max(0, this.value - other))
    operator fun rangeTo(other: Hp) = Range(start = this, end = other)
    operator fun compareTo(other: Hp) = this.value.compareTo(other.value)

    override fun toString() = "${value}hp"

    data class Range(val start: Hp, val end: Hp) {
        init { require(start.value <= end.value) }

        operator fun contains(hp: Hp) = hp.value in start.value..end.value
    }
}

fun min(a: Hp, b: Hp): Hp = Hp(kotlin.math.min(a.value, b.value))
fun max(a: Hp, b: Hp): Hp = Hp(kotlin.math.max(a.value, b.value))

fun calculateMaximumHp(
    hpDice: HpDice,
    constitutionModifier: Modifier,
    level: Level,
    traits: List<Trait>,
) = calculateMaximumHp(
    hpBase = hpDice.hpBase,
    hpIncrement = hpDice.hpIncrement,
    constitutionModifier = constitutionModifier,
    level = level,
    traits = traits,
)

fun calculateMaximumHp(
    hpBase: Hp,
    hpIncrement: Hp,
    constitutionModifier: Modifier,
    level: Level,
    traits: List<Trait>,
): Hp {
    val hpOn1stLevel = hpBase + constitutionModifier.value
    if (level.value == 1) return hpOn1stLevel

    var hp = hpOn1stLevel
    for (i in 2..level.value) {
        hp += hpIncrement + max(constitutionModifier.value, 1) * (i - 1)
    }

    traits.filterWithHpForLevelAffect().forEach { trait ->
        hp += trait.affect.hpForLevel * level.value
    }

    return hp
}
