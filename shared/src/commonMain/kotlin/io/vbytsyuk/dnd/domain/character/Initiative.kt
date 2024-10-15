package io.vbytsyuk.dnd.domain.character

import io.vbytsyuk.dnd.domain.Modifier
import io.vbytsyuk.dnd.domain.StatType
import kotlin.jvm.JvmInline

@JvmInline
value class Initiative(val modifier: Modifier) {
    override fun toString() = modifier.toString()
}

val Character.initiative: Initiative get() = Initiative(statBlock.modifier(StatType.DEX))
