package io.vbytsyuk.dnd.core.units

@JvmInline
value class Distance(val inches: Int) {
    val feet: Double get() = inches / 12.0

    data class Range(val start: Distance, val end: Distance)

    operator fun rangeTo(other: Distance) = Range(start = this, end = other)
}

val Int.inches: Distance get() = Distance(inches = this)
val Int.feet: Distance get() = Distance(inches = 12 * this)
val Double.feet: Distance get() = Distance(inches = (12 * this).toInt())
