package io.vbytsyuk.dnd.core.character

import io.vbytsyuk.dnd.core.StatType

@JvmInline
value class ArmorClass(val value: Int) {
    override fun toString() = value.toString()
}

val Character.armorClass: ArmorClass get() {
    val dexterityModifier = statBlock.modifier(StatType.DEX)
    val equippedArmor = equipment.equippedArmor.firstOrNull()
    return when {
        equippedArmor != null -> equippedArmor.type.calculateAC(dexterityModifier)
        else -> 10 + dexterityModifier.value
    }.let(::ArmorClass)
}
