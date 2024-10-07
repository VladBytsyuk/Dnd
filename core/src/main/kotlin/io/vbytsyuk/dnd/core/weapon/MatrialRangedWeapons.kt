package io.vbytsyuk.dnd.core.weapon

import io.vbytsyuk.dnd.core.units.d10
import io.vbytsyuk.dnd.core.units.d8
import io.vbytsyuk.dnd.core.units.gold
import io.vbytsyuk.dnd.core.units.lb
import io.vbytsyuk.dnd.core.units.Damage.Type.PIERCING
import io.vbytsyuk.dnd.core.units.*
import io.vbytsyuk.dnd.core.weapon.Weapon.ProficiencyType.MATRIAL
import io.vbytsyuk.dnd.core.weapon.Weapon.Property.*
import io.vbytsyuk.dnd.core.weapon.Weapon.RangeType.RANGED

data object HandCrossbow : Weapon {
    override val rangeType = RANGED
    override val proficiencyType = MATRIAL
    override val cost = 75.gold
    override val damage = 1.d6(PIERCING)
    override val weight = 3.lb
    override val properties = setOf(Ammunition(shortRange = 30, longRange = 120), Light, Loading)
}

data object HeavyCrossbow : Weapon {
    override val rangeType = RANGED
    override val proficiencyType = MATRIAL
    override val cost = 50.gold
    override val damage = 1.d10(PIERCING)
    override val weight = 18.lb
    override val properties = setOf(Ammunition(shortRange = 100, longRange = 400), TwoHanded, Loading, Heavy)
}

data object Longbow : Weapon {
    override val rangeType = RANGED
    override val proficiencyType = MATRIAL
    override val cost = 50.gold
    override val damage = 1.d8(PIERCING)
    override val weight = 2.lb
    override val properties = setOf(Ammunition(shortRange = 150, longRange = 600), TwoHanded, Heavy)
}

data object Blowgun : Weapon {
    override val rangeType = RANGED
    override val proficiencyType = MATRIAL
    override val cost = 10.gold
    override val damage = 1.damage(PIERCING)
    override val weight = 1.lb
    override val properties = setOf(Ammunition(shortRange = 25, longRange = 100), Loading)
}

data object Musket : Weapon {
    override val rangeType = RANGED
    override val proficiencyType = MATRIAL
    override val cost = 500.gold
    override val damage = 1.d12(PIERCING)
    override val weight = 10.lb
    override val properties = setOf(Ammunition(shortRange = 40, longRange = 120), TwoHanded, Loading)
}

data object AutomaticPistol : Weapon {
    override val rangeType = RANGED
    override val proficiencyType = MATRIAL
    override val cost = 1000.gold
    override val damage = 2.d6(PIERCING)
    override val weight = 3.lb
    override val properties = setOf(Reload, Ammunition(shortRange = 50, longRange = 150))
}

data object Pistol : Weapon {
    override val rangeType = RANGED
    override val proficiencyType = MATRIAL
    override val cost = 250.gold
    override val damage = 1.d10(PIERCING)
    override val weight = 3.lb
    override val properties = setOf(Ammunition(shortRange = 30, longRange = 90), Loading)
}

data object Net : Weapon {
    override val rangeType = RANGED
    override val proficiencyType = MATRIAL
    override val cost = 1.gold
    override val damage = 0.damage(PIERCING)
    override val weight = 3.lb
    override val properties = setOf(Thrown(shortRange = 5, longRange = 15), Special)
}
