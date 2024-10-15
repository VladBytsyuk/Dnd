package io.vbytsyuk.dnd.domain.units

enum class Alignment {
    LAWFUL_GOOD, LAWFUL_NEUTRAL, LAWFUL_EVIL,
    NEUTRAL_GOOD, TRUE_NEUTRAL, NEUTRAL_EVIL,
    CHAOTIC_GOOD, CHAOTIC_NEUTRAL, CHAOTIC_EVIL,
    UNALIGNED,
}

enum class LawVsChaos { LAWFUL, NEUTRAL, CHAOTIC }
enum class GoodVsEvil { GOOD, NEUTRAL, EVIL }

operator fun LawVsChaos.plus(other: GoodVsEvil): Alignment = when (this) {
    LawVsChaos.LAWFUL -> when (other) {
        GoodVsEvil.GOOD -> Alignment.LAWFUL_GOOD
        GoodVsEvil.NEUTRAL -> Alignment.LAWFUL_NEUTRAL
        GoodVsEvil.EVIL -> Alignment.LAWFUL_EVIL
    }
    LawVsChaos.NEUTRAL -> when (other) {
        GoodVsEvil.GOOD -> Alignment.NEUTRAL_GOOD
        GoodVsEvil.NEUTRAL -> Alignment.TRUE_NEUTRAL
        GoodVsEvil.EVIL -> Alignment.NEUTRAL_EVIL
    }
    LawVsChaos.CHAOTIC -> when (other) {
        GoodVsEvil.GOOD -> Alignment.CHAOTIC_GOOD
        GoodVsEvil.NEUTRAL -> Alignment.CHAOTIC_NEUTRAL
        GoodVsEvil.EVIL -> Alignment.CHAOTIC_EVIL
    }
}

operator fun GoodVsEvil.plus(other: LawVsChaos): Alignment = other + this
