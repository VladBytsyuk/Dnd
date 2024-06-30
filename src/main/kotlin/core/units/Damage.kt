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

fun Int.damage(type: Damage.Type): Damage = Damage(amount = this, dice = Dice.D1, type = type)

fun Int.d4(type: Damage.Type): Damage = Damage(amount = this, dice = Dice.D4, type = type)

fun Int.d6(type: Damage.Type): Damage = Damage(amount = this, dice = Dice.D6, type = type)

fun Int.d8(type: Damage.Type): Damage = Damage(amount = this, dice = Dice.D8, type = type)

fun Int.d10(type: Damage.Type): Damage = Damage(amount = this, dice = Dice.D10, type = type)

fun Int.d12(type: Damage.Type): Damage = Damage(amount = this, dice = Dice.D12, type = type)
