package io.vbytsyuk.dnd.domain.core.units

enum class TimeType(
    val coefficient: Int,
) {
    SECOND(coefficient = 1),
    MINUTE(coefficient = 60),
    HOUR(coefficient = 3600),
    DAY(coefficient = 86400);
}

data class Time(val amount: Int, val type: TimeType) {

    init {
        require(amount >= 0) { "Time [$this] should be positive." }
    }
}

val Int.seconds get() = Time(amount = this, type = TimeType.SECOND)
val Int.minutes get() = Time(amount = this, type = TimeType.MINUTE)
val Int.hours get() = Time(amount = this, type = TimeType.HOUR)
val Int.days get() = Time(amount = this, type = TimeType.DAY)
