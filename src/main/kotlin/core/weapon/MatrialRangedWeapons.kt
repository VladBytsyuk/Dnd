package io.vbytsyuk.dnd.core.weapon

import io.vbytsyuk.dnd.core.Damage
import io.vbytsyuk.dnd.core.Damage.Type.PIERCING
import io.vbytsyuk.dnd.core.Dice.*
import io.vbytsyuk.dnd.core.money.CoinType.GOLD
import io.vbytsyuk.dnd.core.money.Coins
import io.vbytsyuk.dnd.core.weapon.Weapon.Property.*
import io.vbytsyuk.dnd.core.weapon.Weapon.Type.MATRIAL_RANGED

data object HandCrossbow : Weapon(
    type = MATRIAL_RANGED,
    cost = Coins(75, GOLD),
    damage = Damage(dice = D6, type = PIERCING),
    weight = 3.0,
    properties = listOf(Ammunition(shortRange = 30, longRange = 120), Light, Loading),
)

data object HeavyCrossbow : Weapon(
    type = MATRIAL_RANGED,
    cost = Coins(50, GOLD),
    damage = Damage(dice = D10, type = PIERCING),
    weight = 18.0,
    properties = listOf(Ammunition(shortRange = 100, longRange = 400), TwoHanded, Loading, Heavy),
)

data object Longbow : Weapon(
    type = MATRIAL_RANGED,
    cost = Coins(50, GOLD),
    damage = Damage(dice = D8, type = PIERCING),
    weight = 2.0,
    properties = listOf(Ammunition(shortRange = 150, longRange = 600), TwoHanded, Heavy),
)

data object Blowgun : Weapon(
    type = MATRIAL_RANGED,
    cost = Coins(10, GOLD),
    damage = Damage(amount = 1, type = PIERCING),
    weight = 1.0,
    properties = listOf(Ammunition(shortRange = 25, longRange = 100), Loading),
)

data object Musket : Weapon(
    type = MATRIAL_RANGED,
    cost = Coins(500, GOLD),
    damage = Damage(dice = D12, type = PIERCING),
    weight = 10.0,
    properties = listOf(Ammunition(shortRange = 40, longRange = 120), TwoHanded, Loading),
)

data object AutomaticPistol : Weapon(
    type = MATRIAL_RANGED,
    cost = Coins(500, GOLD),
    damage = Damage(2, dice = D6, type = PIERCING),
    weight = 3.0,
    properties = listOf(Reload, Ammunition(shortRange = 50, longRange = 150)),
)

data object Pistol : Weapon(
    type = MATRIAL_RANGED,
    cost = Coins(250, GOLD),
    damage = Damage(dice = D10, type = PIERCING),
    weight = 3.0,
    properties = listOf(Ammunition(shortRange = 30, longRange = 90), Loading),
)

data object Net : Weapon(
    type = MATRIAL_RANGED,
    cost = Coins(1, GOLD),
    damage = Damage(amount = 0, type = PIERCING),
    weight = 3.0,
    properties = listOf(Thrown(shortRange = 5, longRange = 15), Special),
)
