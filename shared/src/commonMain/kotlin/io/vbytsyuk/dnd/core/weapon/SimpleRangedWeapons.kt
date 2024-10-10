@file:Suppress("MagicNumber") package io.vbytsyuk.dnd.core.weapon

import io.vbytsyuk.dnd.core.units.Damage.Type.BLUDGEONING
import io.vbytsyuk.dnd.core.units.Damage.Type.PIERCING
import io.vbytsyuk.dnd.core.units.copper
import io.vbytsyuk.dnd.core.units.d4
import io.vbytsyuk.dnd.core.units.d6
import io.vbytsyuk.dnd.core.units.d8
import io.vbytsyuk.dnd.core.units.gold
import io.vbytsyuk.dnd.core.units.lb
import io.vbytsyuk.dnd.core.units.silver
import io.vbytsyuk.dnd.core.weapon.Weapon.ProficiencyType.SIMPLE
import io.vbytsyuk.dnd.core.weapon.Weapon.Property.Ammunition
import io.vbytsyuk.dnd.core.weapon.Weapon.Property.Finesse
import io.vbytsyuk.dnd.core.weapon.Weapon.Property.Loading
import io.vbytsyuk.dnd.core.weapon.Weapon.Property.Thrown
import io.vbytsyuk.dnd.core.weapon.Weapon.Property.TwoHanded
import io.vbytsyuk.dnd.core.weapon.Weapon.RangeType.RANGED

data object LightCrossbow : Weapon {
    override val rangeType = RANGED
    override val proficiencyType = SIMPLE
    override val cost = 25.gold
    override val damage = 1.d8(PIERCING)
    override val weight = 5.lb
    override val properties = setOf(TwoHanded, Ammunition(shortRange = 80, longRange = 320), Loading)
}

data object Dart : Weapon {
    override val rangeType = RANGED
    override val proficiencyType = SIMPLE
    override val cost = 5.copper
    override val damage = 1.d4(PIERCING)
    override val weight = 0.25.lb
    override val properties = setOf(Thrown(shortRange = 20, longRange = 60), Finesse)
}

data object Shortbow : Weapon {
    override val rangeType = RANGED
    override val proficiencyType = SIMPLE
    override val cost = 25.gold
    override val damage = 1.d6(PIERCING)
    override val weight = 2.lb
    override val properties = setOf(Ammunition(shortRange = 80, longRange = 320), TwoHanded)
}

data object Sling : Weapon {
    override val rangeType = RANGED
    override val proficiencyType = SIMPLE
    override val cost = 1.silver
    override val damage = 1.d4(BLUDGEONING)
    override val weight = 0.1.lb
    override val properties = setOf(Ammunition(shortRange = 30, longRange = 120))
}
