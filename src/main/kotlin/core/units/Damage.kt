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
        val dice: io.vbytsyuk.dnd.core.Dice,
    )

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
            }
            normalizedList += Entry(dices = normalizedDicesGroups, type = type)
        }
        return normalizedList
    }
}

fun Int.damage(type: Damage.Type): Damage = Damage(
    entries = listOf(Damage.Entry(dices = listOf(Damage.Dices(amount = this, dice = Dice.D1)), type = type)),
)

fun Int.d4(type: Damage.Type): Damage = Damage(
    entries = listOf(Damage.Entry(dices = listOf(Damage.Dices(amount = this, dice = Dice.D4)), type = type)),
)

fun Int.d6(type: Damage.Type): Damage = Damage(
    entries = listOf(Damage.Entry(dices = listOf(Damage.Dices(amount = this, dice = Dice.D6)), type = type)),
)

fun Int.d8(type: Damage.Type): Damage = Damage(
    entries = listOf(Damage.Entry(dices = listOf(Damage.Dices(amount = this, dice = Dice.D8)), type = type)),
)

fun Int.d10(type: Damage.Type): Damage = Damage(
    entries = listOf(Damage.Entry(dices = listOf(Damage.Dices(amount = this, dice = Dice.D10)), type = type)),
)

fun Int.d12(type: Damage.Type): Damage = Damage(
    entries = listOf(Damage.Entry(dices = listOf(Damage.Dices(amount = this, dice = Dice.D12)), type = type)),
)
