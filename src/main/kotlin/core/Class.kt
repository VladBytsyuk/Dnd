package io.vbytsyuk.dnd.core

sealed class Class(val hpDice: HpDice)

data object Bard : Class(hpDice = Dice.D8)
data object Barbarian : Class(hpDice = Dice.D12)
data object Fighter : Class(hpDice = Dice.D10)
data object Wizard : Class(hpDice = Dice.D6)
data object Druid : Class(hpDice = Dice.D8)
data object Cleric : Class(hpDice = Dice.D8)
data object Artificer : Class(hpDice = Dice.D8)
data object Warlock : Class(hpDice = Dice.D8)
data object Monk : Class(hpDice = Dice.D8)
data object Paladin : Class(hpDice = Dice.D10)
data object Rogue : Class(hpDice = Dice.D8)
data object Ranger : Class(hpDice = Dice.D10)
data object Sorcerer : Class(hpDice = Dice.D6)
