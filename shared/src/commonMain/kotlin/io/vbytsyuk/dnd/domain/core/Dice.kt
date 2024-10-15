package io.vbytsyuk.dnd.domain.core

import io.vbytsyuk.dnd.domain.core.units.Hp

sealed interface HpDice {
    val hpBase: Hp
    val hpIncrement: Hp
}

@Suppress("MagicNumber")
sealed class Dice(val maxValue: Int) {

    val valuesRange: IntRange = 1..maxValue

    data object D1 : Dice(maxValue = 1) {
        override fun toString() = "d1"
    }
    data object D4 : Dice(maxValue = 4) {
        override fun toString() = "d4"
    }
    data object D6 : Dice(maxValue = 6), HpDice {
        override val hpBase: Hp = Hp(maxValue)
        override val hpIncrement: Hp = Hp(4)
        override fun toString() = "d6"
    }
    data object D8 : Dice(maxValue = 8), HpDice {
        override val hpBase: Hp = Hp(maxValue)
        override val hpIncrement: Hp = Hp(5)
        override fun toString() = "d8"
    }
    data object D10 : Dice(maxValue = 10), HpDice {
        override val hpBase: Hp = Hp(maxValue)
        override val hpIncrement: Hp = Hp(6)
        override fun toString() = "d10"
    }
    data object D12 : Dice(maxValue = 12), HpDice {
        override val hpBase: Hp = Hp(maxValue)
        override val hpIncrement: Hp = Hp(7)
        override fun toString() = "d12"
    }
    data object D20 : Dice(maxValue = 20) {
        override fun toString() = "d20"
    }
    data object D100 : Dice(maxValue = 100) {
        override fun toString() = "d100"
    }
}
