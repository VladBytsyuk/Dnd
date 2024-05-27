package io.vbytsyuk.dnd.core.weapon

import io.vbytsyuk.dnd.core.Damage
import io.vbytsyuk.dnd.core.Damage.Type.*
import io.vbytsyuk.dnd.core.Dice.*
import io.vbytsyuk.dnd.core.money.gold
import io.vbytsyuk.dnd.core.weapon.Weapon.ProficiencyType.MATRIAL
import io.vbytsyuk.dnd.core.weapon.Weapon.Property.*
import io.vbytsyuk.dnd.core.weapon.Weapon.RangeType.MELEE

data object Halberd : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 20.gold,
    damage = Damage(dice = D10, type = SLASHING),
    weight = 6.0,
    properties = listOf(TwoHanded, Reach, Heavy),
)

data object WarPick : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 5.gold,
    damage = Damage(dice = D8, type = PIERCING),
    weight = 2.0,
)

data object Warhammer : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 15.gold,
    damage = Damage(dice = D8, type = BLUDGEONING),
    weight = 2.0,
    properties = listOf(Versatile(twoHandedDice = D10)),
)

data object Battleaxe : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 10.gold,
    damage = Damage(dice = D8, type = SLASHING),
    weight = 4.0,
    properties = listOf(Versatile(twoHandedDice = D10)),
)

data object Glaive : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 20.gold,
    damage = Damage(dice = D10, type = SLASHING),
    weight = 6.0,
    properties = listOf(TwoHanded, Reach, Heavy),
)

data object Greatsword : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 50.gold,
    damage = Damage(2, dice = D6, type = SLASHING),
    weight = 6.0,
    properties = listOf(TwoHanded, Heavy),
)

data object Lance : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 10.gold,
    damage = Damage(dice = D12, type = PIERCING),
    weight = 6.0,
    properties = listOf(Reach, Special),
)

data object Longsword : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 15.gold,
    damage = Damage(dice = D8, type = SLASHING),
    weight = 3.0,
    properties = listOf(Versatile(twoHandedDice = D10)),
)

data object Whip : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 2.gold,
    damage = Damage(dice = D4, type = SLASHING),
    weight = 3.0,
    properties = listOf(Reach, Finesse),
)

data object Shortsword : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 10.gold,
    damage = Damage(dice = D6, type = PIERCING),
    weight = 2.0,
    properties = listOf(Light, Finesse),
)

data object Maul : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 10.gold,
    damage = Damage(2, dice = D6, type = BLUDGEONING),
    weight = 10.0,
    properties = listOf(TwoHanded, Heavy),
)

data object Morningstar : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 15.gold,
    damage = Damage(dice = D8, type = PIERCING),
    weight = 4.0,
)

data object Pike : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 5.gold,
    damage = Damage(dice = D10, type = PIERCING),
    weight = 18.0,
    properties = listOf(TwoHanded, Reach, Heavy),
)

data object Rapier : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 25.gold,
    damage = Damage(dice = D8, type = PIERCING),
    weight = 2.0,
    properties = listOf(Finesse),
)

data object Greataxe : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 30.gold,
    damage = Damage(dice = D12, type = SLASHING),
    weight = 7.0,
    properties = listOf(TwoHanded, Heavy),
)

data object Scimitar : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 25.gold,
    damage = Damage(dice = D6, type = SLASHING),
    weight = 3.0,
    properties = listOf(Light, Finesse),
)

data object Trident : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 5.gold,
    damage = Damage(dice = D6, type = PIERCING),
    weight = 4.0,
    properties = listOf(Thrown(shortRange = 20, longRange = 60), Versatile(twoHandedDice = D8)),
)

data object Flail : Weapon(
    rangeType = MELEE,
    proficiencyType = MATRIAL,
    cost = 10.gold,
    damage = Damage(dice = D8, type = BLUDGEONING),
    weight = 2.0,
)
