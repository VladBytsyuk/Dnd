package io.vbytsyuk.dnd.domain.core.units

import kotlin.jvm.JvmInline

@JvmInline
value class Distance(val inches: Int) {

    @Suppress("MagicNumber")
    val feet: Double get() = inches / 12.0

    override fun toString() = "${feet.toInt()} feet"

    data class Range(val start: Distance, val end: Distance) {
        init { require(start.inches <= end.inches) }
        
        operator fun contains(distance: Distance) = distance.inches in start.inches..end.inches
    }

    operator fun rangeTo(other: Distance) = Range(start = this, end = other)
}

val Int.inches: Distance get() = Distance(inches = this)
val Int.feet: Distance get() = Distance(inches = 12 * this)
val Double.feet: Distance get() = Distance(inches = (12 * this).toInt())

val MAX_DISTANCE = Int.MAX_VALUE.inches
