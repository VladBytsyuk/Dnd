package io.vbytsyuk.dnd.core.units

@JvmInline
value class Level(val value: Int) {
    init { require(value > 0) }
    override fun toString() = "lvl=$value"
}
