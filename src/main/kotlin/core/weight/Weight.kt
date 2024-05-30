package io.vbytsyuk.dnd.core.weight

@JvmInline
value class Weight(val value: Double) {

    data class Range(val start: Weight, val end: Weight)

    operator fun rangeTo(other: Weight) = Range(start = this, end = other)
}

val Int.lb get() = Weight(this.toDouble())
val Double.lb get() = Weight(this)
