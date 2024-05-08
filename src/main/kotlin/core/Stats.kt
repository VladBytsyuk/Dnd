package io.vbytsyuk.dnd.core

typealias StatType = Int

sealed class Stat private constructor(
    val value: StatType,
    private val shortName: String,
) {
    init { require(value >= 0) }

    val modifier: Modifier
        get() = Modifier(kotlin.math.floor((value - 10) / 2.0).toInt())

    class Strength(value: StatType = 1) : Stat(value, shortName = "str")
    class Dexterity(value: StatType = 1) : Stat(value, shortName = "dex")
    class Constitution(value: StatType = 1) : Stat(value, shortName = "con")
    class Intelligence(value: StatType = 1) : Stat(value, shortName = "int")
    class Wisdom(value: StatType = 1) : Stat(value, shortName = "wis")
    class Charisma(value: StatType = 1) : Stat(value, shortName = "cha")

    override fun toString() = "$shortName=$value($modifier)"
}

@JvmInline
value class Modifier(val value: Int) {
    override fun toString() = if (value < 0) "$value" else "+$value"
}

data class StatBlock(
    val strength: Stat.Strength,
    val dexterity: Stat.Dexterity,
    val constitution: Stat.Constitution,
    val intelligence: Stat.Intelligence,
    val wisdom: Stat.Wisdom,
    val charisma: Stat.Charisma,
) {
    constructor(
        strength: StatType = 0,
        dexterity: StatType = 0,
        constitution: StatType = 0,
        intelligence: StatType = 0,
        wisdom: StatType = 0,
        charisma: StatType = 0,
    ) : this(
        strength = Stat.Strength(strength),
        dexterity = Stat.Dexterity(dexterity),
        constitution = Stat.Constitution(constitution),
        intelligence = Stat.Intelligence(intelligence),
        wisdom = Stat.Wisdom(wisdom),
        charisma = Stat.Charisma(charisma),
    )

    override fun toString() =
        listOf(strength, dexterity, constitution, intelligence, wisdom, charisma).joinToString(prefix = "[", postfix = "]")

    operator fun plus(other: StatBlock): StatBlock = StatBlock(
        strength = this.strength.value + other.strength.value,
        dexterity = this.dexterity.value + other.dexterity.value,
        constitution = this.constitution.value + other.constitution.value,
        intelligence = this.intelligence.value + other.intelligence.value,
        wisdom = this.wisdom.value + other.wisdom.value,
        charisma = this.charisma.value + other.charisma.value,
    )

    fun applyChosenStats(vararg chosenStats: Stat) = chosenStats.fold(initial = this) { acc, chosenStat ->
        when (chosenStat) {
            is Stat.Strength -> acc.copy(strength = Stat.Strength(acc.strength.value + 1))
            is Stat.Dexterity -> acc.copy(dexterity = Stat.Dexterity(acc.dexterity.value + 1))
            is Stat.Constitution -> acc.copy(constitution = Stat.Constitution(acc.constitution.value + 1))
            is Stat.Intelligence -> acc.copy(intelligence = Stat.Intelligence(acc.intelligence.value + 1))
            is Stat.Wisdom -> acc.copy(wisdom = Stat.Wisdom(acc.wisdom.value + 1))
            is Stat.Charisma -> acc.copy(charisma = Stat.Charisma(acc.charisma.value + 1))
        }
    }
}
