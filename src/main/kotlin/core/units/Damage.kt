package io.vbytsyuk.dnd.core.units

import io.vbytsyuk.dnd.core.Dice

data class Damage(
    val entries: List<Entry>,
) {

    data class Entry(
        val dices: List<Dices>,
        val type: Type,
    )

    data class Dices(
        val amount: Int = 1,
        val dice: Dice,
    ) {

        operator fun plus(other: Dices): List<Dices> = listOf(this, other)
    }

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

    operator fun plus(other: Damage): Damage {
        val entriesUnion = this.entries + other.entries
        return Damage(entries = entriesUnion.normalize())
    }

    private fun List<Entry>.normalize(): List<Entry> {
        val normalizedList: MutableList<Entry> = mutableListOf()
        val typeGroups = this.groupBy { it.type }
        typeGroups.forEach { (type, entries) ->
            val dices = entries.map { it.dices }.flatten()
            val dicesGroups = dices.groupBy { it.dice }
            val normalizedDicesGroups = dicesGroups.map { (dice, dices) ->
                Dices(amount = dices.sumOf { it.amount }, dice = dice)
            }.sortedByDescending { it.dice.maxValue }
            normalizedList += Entry(dices = normalizedDicesGroups, type = type)
        }
        return normalizedList
    }
}

fun Int.damage(type: Damage.Type): Damage = Damage(
    entries = listOf(Damage.Entry(dices = listOf(Damage.Dices(amount = this, dice = Dice.D1)), type = type)),
)

fun Damage.Dices.damage(type: Damage.Type): Damage = Damage(
    entries = listOf(Damage.Entry(dices = listOf(this), type = type))
)

fun List<Damage.Dices>.damage(type: Damage.Type): Damage = Damage(
    entries = listOf(Damage.Entry(dices = this, type = type))
)

fun Int.d4(type: Damage.Type): Damage = Damage(
    entries = listOf(Damage.Entry(dices = listOf(this.d4), type = type)),
)

val Int.d4: Damage.Dices get() = Damage.Dices(amount = this, dice = Dice.D4)

fun Int.d6(type: Damage.Type): Damage = Damage(
    entries = listOf(Damage.Entry(dices = listOf(this.d6), type = type)),
)

val Int.d6: Damage.Dices get() = Damage.Dices(amount = this, dice = Dice.D6)

fun Int.d8(type: Damage.Type): Damage = Damage(
    entries = listOf(Damage.Entry(dices = listOf(this.d8), type = type)),
)

val Int.d8: Damage.Dices get() = Damage.Dices(amount = this, dice = Dice.D8)

fun Int.d10(type: Damage.Type): Damage = Damage(
    entries = listOf(Damage.Entry(dices = listOf(this.d10), type = type)),
)

val Int.d10: Damage.Dices get() = Damage.Dices(amount = this, dice = Dice.D10)

fun Int.d12(type: Damage.Type): Damage = Damage(
    entries = listOf(Damage.Entry(dices = listOf(this.d12), type = type)),
)

val Int.d12: Damage.Dices get() = Damage.Dices(amount = this, dice = Dice.D12)
