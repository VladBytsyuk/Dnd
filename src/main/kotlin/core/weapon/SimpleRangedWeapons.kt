package io.vbytsyuk.dnd.core.weapon

import io.vbytsyuk.dnd.core.units.Damage
import io.vbytsyuk.dnd.core.units.Damage.Type.BLUDGEONING
import io.vbytsyuk.dnd.core.units.Damage.Type.PIERCING
import io.vbytsyuk.dnd.core.Dice.*
import io.vbytsyuk.dnd.core.units.copper
import io.vbytsyuk.dnd.core.units.gold
import io.vbytsyuk.dnd.core.units.silver
import io.vbytsyuk.dnd.core.weapon.Weapon.ProficiencyType.SIMPLE
import io.vbytsyuk.dnd.core.weapon.Weapon.Property.*
import io.vbytsyuk.dnd.core.weapon.Weapon.RangeType.RANGED
import io.vbytsyuk.dnd.core.units.lb

data object LightCrossbow : Weapon(
    rangeType = RANGED,
    proficiencyType = SIMPLE,
    cost = 25.gold,
    damage = Damage(dice = D8, type = PIERCING),
    weight = 5.lb,
    properties = listOf(TwoHanded, Ammunition(shortRange = 80, longRange = 320), Loading),
)

data object Dart : Weapon(
    rangeType = RANGED,
    proficiencyType = SIMPLE,
    cost = 5.copper,
    damage = Damage(dice = D4, type = PIERCING),
    weight = 0.25.lb,
    properties = listOf(Thrown(shortRange = 20, longRange = 60), Finesse),
)

data object Shortbow : Weapon(
    rangeType = RANGED,
    proficiencyType = SIMPLE,
    cost = 25.gold,
    damage = Damage(dice = D6, type = PIERCING),
    weight = 2.lb,
    properties = listOf(Ammunition(shortRange = 80, longRange = 320), TwoHanded),
)

data object Sling : Weapon(
    rangeType = RANGED,
    proficiencyType = SIMPLE,
    cost = 1.silver,
    damage = Damage(dice = D6, type = BLUDGEONING),
    weight = 0.1.lb,
    properties = listOf(Ammunition(shortRange = 30, longRange = 120)),
)
