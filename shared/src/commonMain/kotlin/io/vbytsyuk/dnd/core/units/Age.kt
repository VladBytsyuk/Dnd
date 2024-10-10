package io.vbytsyuk.dnd.core.units

import kotlin.jvm.JvmInline

@JvmInline
value class Age(val value: Int) : Comparable<Age> {

    init { require(value >= 0) }

    override fun toString(): String = "$value year${if (value != 1) "s" else ""}"

    override fun compareTo(other: Age) = this.value.compareTo(other.value)

    data class Range(val start: Age, val end: Age) {
        init { require(start <= end) }

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
