package io.vbytsyuk.dnd.core.weapon

import io.vbytsyuk.dnd.core.Damage
import io.vbytsyuk.dnd.core.Damage.Type.*
import io.vbytsyuk.dnd.core.Dice.*
import io.vbytsyuk.dnd.core.money.CoinType.GOLD
import io.vbytsyuk.dnd.core.money.Coins
import io.vbytsyuk.dnd.core.weapon.Weapon.Property.*
import io.vbytsyuk.dnd.core.weapon.Weapon.Type.MATRIAL_MELEE

data object Halberd : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(20, GOLD),
    damage = Damage(dice = D10, type = SLASHING),
    weight = 6.0,
    properties = listOf(TwoHanded, Reach, Heavy),
)

data object WarPick : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(5, GOLD),
    damage = Damage(dice = D8, type = PIERCING),
    weight = 2.0,
)

data object Warhammer : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(15, GOLD),
    damage = Damage(dice = D8, type = BLUDGEONING),
    weight = 2.0,
    properties = listOf(Versatile(twoHandedDice = D10)),
)

data object Battleaxe : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(10, GOLD),
    damage = Damage(dice = D8, type = SLASHING),
    weight = 4.0,
    properties = listOf(Versatile(twoHandedDice = D10)),
)

data object Glaive : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(20, GOLD),
    damage = Damage(dice = D10, type = SLASHING),
    weight = 6.0,
    properties = listOf(TwoHanded, Reach, Heavy),
)

data object Greatsword : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(50, GOLD),
    damage = Damage(2, dice = D6, type = SLASHING),
    weight = 6.0,
    properties = listOf(TwoHanded, Heavy),
)

data object Lance : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(10, GOLD),
    damage = Damage(dice = D12, type = PIERCING),
    weight = 6.0,
    properties = listOf(Reach, Special),
)

data object Longsword : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(15, GOLD),
    damage = Damage(dice = D8, type = SLASHING),
    weight = 3.0,
    properties = listOf(Versatile(twoHandedDice = D10)),
)

data object Whip : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(2, GOLD),
    damage = Damage(dice = D4, type = SLASHING),
    weight = 3.0,
    properties = listOf(Reach, Finesse),
)

data object Shortsword : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(10, GOLD),
    damage = Damage(dice = D6, type = PIERCING),
    weight = 2.0,
    properties = listOf(Light, Finesse),
)

data object Maul : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(10, GOLD),
    damage = Damage(2, dice = D6, type = BLUDGEONING),
    weight = 10.0,
    properties = listOf(TwoHanded, Heavy),
)

data object Morningstar : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(15, GOLD),
    damage = Damage(dice = D8, type = PIERCING),
    weight = 4.0,
)

data object Pike : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(5, GOLD),
    damage = Damage(dice = D10, type = PIERCING),
    weight = 18.0,
    properties = listOf(TwoHanded, Reach, Heavy),
)

data object Rapier : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(25, GOLD),
    damage = Damage(dice = D8, type = PIERCING),
    weight = 2.0,
    properties = listOf(Finesse),
)

data object Greataxe : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(30, GOLD),
    damage = Damage(dice = D12, type = SLASHING),
    weight = 7.0,
    properties = listOf(TwoHanded, Heavy),
)

data object Scimitar : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(25, GOLD),
    damage = Damage(dice = D6, type = SLASHING),
    weight = 3.0,
    properties = listOf(Light, Finesse),
)

data object Trident : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(5, GOLD),
    damage = Damage(dice = D6, type = PIERCING),
    weight = 4.0,
    properties = listOf(Thrown(shortRange = 20, longRange = 60), Versatile(twoHandedDice = D8)),
)

data object Flail : Weapon(
    type = MATRIAL_MELEE,
    cost = Coins(10, GOLD),
    damage = Damage(dice = D8, type = BLUDGEONING),
    weight = 2.0,
)
