package io.vbytsyuk.dnd.core.length

@JvmInline
value class Length(val inches: Int) {
    val feet: Double get() = inches / 12.0

    data class Range(val start: Length, val end: Length)

    operator fun rangeTo(other: Length) = Range(start = this, end = other)
}

val Int.inches: Length get() = Length(inches = this)
val Int.feet: Length get() = Length(inches = 12 * this)
val Double.feet: Length get() = Length(inches = (12 * this).toInt())
