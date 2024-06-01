package io.vbytsyuk.dnd.core.character

import io.vbytsyuk.dnd.core.Modifier
import io.vbytsyuk.dnd.core.StatType

@JvmInline
value class Initiative(val modifier: Modifier) {
    override fun toString() = modifier.toString()
}

val Character.initiative: Initiative get() = Initiative(statBlock.modifier(StatType.DEX))
