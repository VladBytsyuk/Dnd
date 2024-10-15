package io.vbytsyuk.dnd.domain.core.character

import io.vbytsyuk.dnd.domain.core.Modifier
import io.vbytsyuk.dnd.domain.core.StatType
import kotlin.jvm.JvmInline

@JvmInline
value class Initiative(val modifier: Modifier) {
    override fun toString() = modifier.toString()
}

val Character.initiative: Initiative get() = Initiative(statBlock.modifier(StatType.DEX))
