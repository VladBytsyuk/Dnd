package io.vbytsyuk.dnd.core.units

@JvmInline
value class Age(val value: Int) {

    data class Range(val start: Age, val end: Age) {
        init { require(start.value <= end.value) }

        operator fun contains(age: Age) = age.value in start.value..end.value
    }

    operator fun rangeTo(other: Age) = Range(start = this, end = other)
}

val Int.years: Age get() = Age(this)

data class AgeInfo(
    val mature: Age,
    val limit: Age.Range,
) {

    constructor(mature: Age, limit: Age) : this(mature = mature, limit = limit..limit)
}
