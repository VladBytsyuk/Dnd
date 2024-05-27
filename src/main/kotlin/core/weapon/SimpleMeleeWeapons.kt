package io.vbytsyuk.dnd.core.weapon

import io.vbytsyuk.dnd.core.Damage
import io.vbytsyuk.dnd.core.Damage.Type.*
import io.vbytsyuk.dnd.core.Dice.*
import io.vbytsyuk.dnd.core.money.gold
import io.vbytsyuk.dnd.core.money.silver
import io.vbytsyuk.dnd.core.weapon.Weapon.ProficiencyType.SIMPLE
import io.vbytsyuk.dnd.core.weapon.Weapon.Property.*
import io.vbytsyuk.dnd.core.weapon.Weapon.RangeType.MELEE
import io.vbytsyuk.dnd.core.weight.lb

data object Quarterstaff : Weapon(
    rangeType = MELEE,
    proficiencyType = SIMPLE,
    cost = 2.silver,
    damage = Damage(dice = D6, type = BLUDGEONING),
    weight = 4.lb,
    properties = listOf(Versatile(twoHandedDice = D8)),
)

data object Mace : Weapon(
    rangeType = MELEE,
    proficiencyType = SIMPLE,
    cost = 5.gold,
    damage = Damage(dice = D6, type = BLUDGEONING),
    weight = 4.lb,
)

data object Club : Weapon(
    rangeType = MELEE,
    proficiencyType = SIMPLE,
    cost = 1.silver,
    damage = Damage(dice = D4, type = BLUDGEONING),
    weight = 2.lb,
    properties = listOf(Light)
)

data object Dagger : Weapon(
    rangeType = MELEE,
    proficiencyType = SIMPLE,
    cost = 2.gold,
    damage = Damage(dice = D4, type = PIERCING),
    weight = 1.lb,
    properties = listOf(Light, Finesse, Thrown(shortRange = 20, longRange = 60)),
)

data object Spear : Weapon(
    rangeType = MELEE,
    proficiencyType = SIMPLE,
    cost = 1.gold,
    damage = Damage(dice = D6, type = PIERCING),
    weight = 3.lb,
    properties = listOf(Thrown(shortRange = 20, longRange = 60), Versatile(twoHandedDice = D8)),
)

data object LightHammer : Weapon(
    rangeType = MELEE,
    proficiencyType = SIMPLE,
    cost = 2.gold,
    damage = Damage(dice = D4, type = BLUDGEONING),
    weight = 2.lb,
    properties = listOf(Light, Thrown(shortRange = 20, longRange = 60)),
)

data object Javelin : Weapon(
    rangeType = MELEE,
    proficiencyType = SIMPLE,
    cost = 5.silver,
    damage = Damage(dice = D6, type = PIERCING),
    weight = 2.lb,
    properties = listOf(Thrown(shortRange = 30, longRange = 120)),
)

data object Greatclub : Weapon(
    rangeType = MELEE,
    proficiencyType = SIMPLE,
    cost = 2.silver,
    damage = Damage(dice = D8, type = BLUDGEONING),
    weight = 10.lb,
    properties = listOf(TwoHanded),
)

data object Handaxe : Weapon(
    rangeType = MELEE,
    proficiencyType = SIMPLE,
    cost = 5.gold,
    damage = Damage(dice = D6, type = SLASHING),
    weight = 2.lb,
    properties = listOf(Light, Thrown(shortRange = 20, longRange = 60)),
)

data object Sickle : Weapon(
    rangeType = MELEE,
    proficiencyType = SIMPLE,
    cost = 1.gold,
    damage = Damage(dice = D4, type = SLASHING),
    weight = 2.lb,
    properties = listOf(Light),
)
