package io.vbytsyuk.dnd.core.weapon

import io.vbytsyuk.dnd.core.Damage
import io.vbytsyuk.dnd.core.Damage.Type.PIERCING
import io.vbytsyuk.dnd.core.Dice.*
import io.vbytsyuk.dnd.core.money.gold
import io.vbytsyuk.dnd.core.weapon.Weapon.ProficiencyType.MATRIAL
import io.vbytsyuk.dnd.core.weapon.Weapon.Property.*
import io.vbytsyuk.dnd.core.weapon.Weapon.RangeType.RANGED
import io.vbytsyuk.dnd.core.weight.lb

data object HandCrossbow : Weapon(
    rangeType = RANGED,
    proficiencyType = MATRIAL,
    cost = 75.gold,
    damage = Damage(dice = D6, type = PIERCING),
    weight = 3.lb,
    properties = listOf(Ammunition(shortRange = 30, longRange = 120), Light, Loading),
)

data object HeavyCrossbow : Weapon(
    rangeType = RANGED,
    proficiencyType = MATRIAL,
    cost = 50.gold,
    damage = Damage(dice = D10, type = PIERCING),
    weight = 18.lb,
    properties = listOf(Ammunition(shortRange = 100, longRange = 400), TwoHanded, Loading, Heavy),
)

data object Longbow : Weapon(
    rangeType = RANGED,
    proficiencyType = MATRIAL,
    cost = 50.gold,
    damage = Damage(dice = D8, type = PIERCING),
    weight = 2.lb,
    properties = listOf(Ammunition(shortRange = 150, longRange = 600), TwoHanded, Heavy),
)

data object Blowgun : Weapon(
    rangeType = RANGED,
    proficiencyType = MATRIAL,
    cost = 10.gold,
    damage = Damage(amount = 1, type = PIERCING),
    weight = 1.lb,
    properties = listOf(Ammunition(shortRange = 25, longRange = 100), Loading),
)

data object Musket : Weapon(
    rangeType = RANGED,
    proficiencyType = MATRIAL,
    cost = 500.gold,
    damage = Damage(dice = D12, type = PIERCING),
    weight = 10.lb,
    properties = listOf(Ammunition(shortRange = 40, longRange = 120), TwoHanded, Loading),
)

data object AutomaticPistol : Weapon(
    rangeType = RANGED,
    proficiencyType = MATRIAL,
    cost = 1000.gold,
    damage = Damage(2, dice = D6, type = PIERCING),
    weight = 3.lb,
    properties = listOf(Reload, Ammunition(shortRange = 50, longRange = 150)),
)

data object Pistol : Weapon(
    rangeType = RANGED,
    proficiencyType = MATRIAL,
    cost = 250.gold,
    damage = Damage(dice = D10, type = PIERCING),
    weight = 3.lb,
    properties = listOf(Ammunition(shortRange = 30, longRange = 90), Loading),
)

data object Net : Weapon(
    rangeType = RANGED,
    proficiencyType = MATRIAL,
    cost = 1.gold,
    damage = Damage(amount = 0, type = PIERCING),
    weight = 3.lb,
    properties = listOf(Thrown(shortRange = 5, longRange = 15), Special),
)
