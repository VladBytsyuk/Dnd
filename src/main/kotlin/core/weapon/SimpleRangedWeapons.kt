package io.vbytsyuk.dnd.core.weapon

import io.vbytsyuk.dnd.core.Damage
import io.vbytsyuk.dnd.core.Damage.Type.BLUDGEONING
import io.vbytsyuk.dnd.core.Damage.Type.PIERCING
import io.vbytsyuk.dnd.core.Dice.*
import io.vbytsyuk.dnd.core.money.CoinType.*
import io.vbytsyuk.dnd.core.money.Coins
import io.vbytsyuk.dnd.core.weapon.Weapon.Property.*
import io.vbytsyuk.dnd.core.weapon.Weapon.Type.SIMPLE_RANGED

data object LightCrossbow : Weapon(
    type = SIMPLE_RANGED,
    cost = Coins(25, GOLD),
    damage = Damage(dice = D8, type = PIERCING),
    weight = 5.0,
    properties = listOf(TwoHanded, Ammunition(shortRange = 80, longRange = 320), Loading),
)

data object Dart : Weapon(
    type = SIMPLE_RANGED,
    cost = Coins(5, COPPER),
    damage = Damage(dice = D4, type = PIERCING),
    weight = 0.25,
    properties = listOf(Thrown(shortRange = 20, longRange = 60), Finesse),
)

data object Shortbow : Weapon(
    type = SIMPLE_RANGED,
    cost = Coins(25, GOLD),
    damage = Damage(dice = D6, type = PIERCING),
    weight = 2.0,
    properties = listOf(Ammunition(shortRange = 80, longRange = 320), TwoHanded),
)

data object Sling : Weapon(
    type = SIMPLE_RANGED,
    cost = Coins(1, SILVER),
    damage = Damage(dice = D6, type = BLUDGEONING),
    weight = 0.1,
    properties = listOf(Ammunition(shortRange = 30, longRange = 120)),
)
