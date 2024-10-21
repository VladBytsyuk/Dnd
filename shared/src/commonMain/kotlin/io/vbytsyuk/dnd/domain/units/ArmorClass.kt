package io.vbytsyuk.dnd.domain.units

data class ArmorClass(
    val base: Int,
    val hasDexBonus: Boolean,
    val maxBonus: Int,
)
