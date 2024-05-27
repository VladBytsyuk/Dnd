package io.vbytsyuk.dnd.core.weight

@JvmInline
value class Weight(val value: Double)

val Int.lb get() = Weight(this.toDouble())
val Double.lb get() = Weight(this)
