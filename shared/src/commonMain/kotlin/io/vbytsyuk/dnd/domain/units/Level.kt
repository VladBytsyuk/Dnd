package io.vbytsyuk.dnd.domain.units

import kotlin.jvm.JvmInline

@JvmInline
value class Level(val value: Int) {
    init { require(value > 0) }
    override fun toString() = "lvl=$value"
}

val Int.level: Level get() = Level(this)
