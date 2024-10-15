package io.vbytsyuk.dnd.domain.core.units

import kotlin.jvm.JvmInline

@JvmInline
value class Speed(val value: Distance) {
    override fun toString() = "${value.feet.toInt()} feet"
}
