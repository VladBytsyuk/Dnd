package io.vbytsyuk.dnd.core.character

import io.vbytsyuk.dnd.core.StatType
import kotlin.jvm.JvmInline

@JvmInline
value class ArmorClass(val value: Int) {
    override fun toString() = value.toString()
}

val Character.armorClass: ArmorClass
    get() {
    val dexterityModifier = statBlock.modifier(StatType.DEX)
    val equippedArmor = equipment.equippedArmor.firstOrNull()
    return when {
        equippedArmor != null -> equippedArmor.type.calculateAC(dexterityModifier)
        else -> BASE_AC + dexterityModifier.value
    }.let(::ArmorClass)
}

private const val BASE_AC = 10
