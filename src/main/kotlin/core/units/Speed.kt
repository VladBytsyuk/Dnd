package io.vbytsyuk.dnd.core.units

@JvmInline
value class Speed(val value: Distance) {
    override fun toString() = "${value.feet.toInt()} feet"
}
