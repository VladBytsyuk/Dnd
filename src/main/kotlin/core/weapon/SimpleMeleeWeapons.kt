package io.vbytsyuk.dnd.core.weapon

import io.vbytsyuk.dnd.core.Damage
import io.vbytsyuk.dnd.core.Damage.Type.*
import io.vbytsyuk.dnd.core.Dice.*
import io.vbytsyuk.dnd.core.money.CoinType.GOLD
import io.vbytsyuk.dnd.core.money.CoinType.SILVER
import io.vbytsyuk.dnd.core.money.Coins
import io.vbytsyuk.dnd.core.weapon.Weapon.Property.*
import io.vbytsyuk.dnd.core.weapon.Weapon.Type.SIMPLE_MELEE

data object Quarterstaff : Weapon(
    type = SIMPLE_MELEE,
    cost = Coins(2, SILVER),
    damage = Damage(dice = D6, type = BLUDGEONING),
    weight = 4.0,
    properties = listOf(Versatile(twoHandedDice = D8)),
)

data object Mace : Weapon(
    type = SIMPLE_MELEE,
    cost = Coins(5, GOLD),
    damage = Damage(dice = D6, type = BLUDGEONING),
    weight = 4.0,
)

data object Club : Weapon(
    type = SIMPLE_MELEE,
    cost = Coins(1, SILVER),
    damage = Damage(dice = D4, type = BLUDGEONING),
    weight = 2.0,
    properties = listOf(Light)
)

data object Dagger : Weapon(
    type = SIMPLE_MELEE,
    cost = Coins(2, GOLD),
    damage = Damage(dice = D4, type = PIERCING),
    weight = 1.0,
    properties = listOf(Light, Finesse, Thrown(shortRange = 20, longRange = 60)),
)

data object Spear : Weapon(
    type = SIMPLE_MELEE,
    cost = Coins(1, GOLD),
    damage = Damage(dice = D6, type = PIERCING),
    weight = 3.0,
    properties = listOf(Thrown(shortRange = 20, longRange = 60), Versatile(twoHandedDice = D8)),
)

data object LightHammer : Weapon(
    type = SIMPLE_MELEE,
    cost = Coins(2, GOLD),
    damage = Damage(dice = D4, type = BLUDGEONING),
    weight = 2.0,
    properties = listOf(Light, Thrown(shortRange = 20, longRange = 60)),
)

data object Javelin : Weapon(
    type = SIMPLE_MELEE,
    cost = Coins(5, SILVER),
    damage = Damage(dice = D6, type = PIERCING),
    weight = 2.0,
    properties = listOf(Thrown(shortRange = 30, longRange = 120)),
)

data object Greatclub : Weapon(
    type = SIMPLE_MELEE,
    cost = Coins(2, SILVER),
    damage = Damage(dice = D8, type = BLUDGEONING),
    weight = 10.0,
    properties = listOf(TwoHanded),
)

data object Handaxe : Weapon(
    type = SIMPLE_MELEE,
    cost = Coins(5, GOLD),
    damage = Damage(dice = D6, type = SLASHING),
    weight = 2.0,
    properties = listOf(Light, Thrown(shortRange = 20, longRange = 60)),
)

data object Sickle : Weapon(
    type = SIMPLE_MELEE,
    cost = Coins(1, GOLD),
    damage = Damage(dice = D4, type = SLASHING),
    weight = 2.0,
    properties = listOf(Light),
)
