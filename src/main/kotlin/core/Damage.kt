package io.vbytsyuk.dnd.core

data class Damage(
    val amount: Int = 1,
    val dice: Dice? = null,
    val type: Type,
) {

    enum class Type { BLUDGEONING, PIERCING, SLASHING }
}
