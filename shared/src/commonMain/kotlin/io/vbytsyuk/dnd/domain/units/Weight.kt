package io.vbytsyuk.dnd.domain.units

import kotlin.jvm.JvmInline

@JvmInline
value class Weight(val value: Double) {

    data class Range(val start: Weight, val end: Weight) {
        init { require(start.value <= end.value) }

        operator fun contains(weight: Weight) = weight.value in start.value..end.value
    }

    operator fun rangeTo(other: Weight) = Range(start = this, end = other)
}

val Int.lb get() = Weight(this.toDouble())
val Double.lb get() = Weight(this)

val MAX_WEIGHT = Int.MAX_VALUE.lb
