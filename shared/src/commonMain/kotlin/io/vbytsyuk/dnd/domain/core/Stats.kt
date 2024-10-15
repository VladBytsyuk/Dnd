package io.vbytsyuk.dnd.domain.core

import kotlin.jvm.JvmInline
import kotlin.math.floor

typealias StatValue = Int

enum class StatType { STR, DEX, CON, INT, WIS, CHA }

@JvmInline
value class Modifier(val value: Int) {
    override fun toString() = if (value < 0) "$value" else "+$value"

    operator fun plus(other: Modifier): Modifier = Modifier(this.value + other.value)

    operator fun compareTo(other: Modifier): Int = this.value.compareTo(other.value)

    fun takeModifierIf(predicate: (Modifier) -> Boolean): Modifier =
        if (predicate(this)) this else Modifier(0)
}

class StatBlock(
    strength: StatValue = 0,
    dexterity: StatValue = 0,
    constitution: StatValue = 0,
    intelligence: StatValue = 0,
    wisdom: StatValue = 0,
    charisma: StatValue = 0,
) {
    private val storage = mapOf(
        StatType.STR to strength,
        StatType.DEX to dexterity,
        StatType.CON to constitution,
        StatType.INT to intelligence,
        StatType.WIS to wisdom,
        StatType.CHA to charisma,
    )

    private fun value(type: StatType) = storage[type] ?: 0

    val strength: StatValue get() = value(StatType.STR)
    val dexterity: StatValue get() = value(StatType.DEX)
    val constitution: StatValue get() = value(StatType.CON)
    val intelligence: StatValue get() = value(StatType.INT)
    val wisdom: StatValue get() = value(StatType.WIS)
    val charisma: StatValue get() = value(StatType.CHA)

    @Suppress("MagicNumber")
    fun modifier(type: StatType): Modifier =
        Modifier(floor((value(type) - 10) / 2.0).toInt())

    override fun toString() =
        storage.entries.joinToString(prefix = "[", postfix = "]") { (type, value) -> "$type=$value(${modifier(type)})" }

    operator fun plus(other: StatBlock): StatBlock = StatBlock(
        strength = this.strength + other.strength,
        dexterity = this.dexterity + other.dexterity,
        constitution = this.constitution + other.constitution,
        intelligence = this.intelligence + other.intelligence,
        wisdom = this.wisdom + other.wisdom,
        charisma = this.charisma + other.charisma,
    )

    private fun copy(
        strength: StatValue? = null,
        dexterity: StatValue? = null,
        constitution: StatValue? = null,
        intelligence: StatValue? = null,
        wisdom: StatValue? = null,
        charisma: StatValue? = null,
    ) = StatBlock(
        strength = strength ?: this.strength,
        dexterity = dexterity ?: this.dexterity,
        constitution = constitution ?: this.constitution,
        intelligence = intelligence ?: this.intelligence,
        wisdom = wisdom ?: this.wisdom,
        charisma = charisma ?: this.charisma,
    )

    fun applyChosenStats(vararg chosenStats: StatType) = chosenStats.fold(initial = this) { acc, chosenStat ->
        when (chosenStat) {
            StatType.STR -> acc.copy(strength = acc.strength + 1)
            StatType.DEX -> acc.copy(dexterity = acc.dexterity + 1)
            StatType.CON -> acc.copy(constitution = acc.constitution + 1)
            StatType.INT -> acc.copy(intelligence = acc.intelligence + 1)
            StatType.WIS -> acc.copy(wisdom = acc.wisdom + 1)
            StatType.CHA -> acc.copy(charisma = acc.charisma + 1)
        }
    }
}
