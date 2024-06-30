package io.vbytsyuk.dnd.core.units

import io.vbytsyuk.dnd.core.Dice

data class Damage(
    val amount: Int = 1,
    val dice: Dice? = null,
    val type: Type,
) {

    enum class Type {
        BLUDGEONING,
        PIERCING,
        SLASHING,
        ACID,
        COLD,
        FIRE,
        FORCE,
        LIGHTNING,
        POISON,
        PSYCHIC,
        RADIANT,
        THUNDER;
    }
}
