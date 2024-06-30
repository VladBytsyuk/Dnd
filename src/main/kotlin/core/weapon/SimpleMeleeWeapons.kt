package io.vbytsyuk.dnd.core.weapon

import io.vbytsyuk.dnd.core.units.Damage.Type.*
import io.vbytsyuk.dnd.core.Dice.*
import io.vbytsyuk.dnd.core.units.*
import io.vbytsyuk.dnd.core.weapon.Weapon.ProficiencyType.SIMPLE
import io.vbytsyuk.dnd.core.weapon.Weapon.Property.*
import io.vbytsyuk.dnd.core.weapon.Weapon.RangeType.MELEE

data object Quarterstaff : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = SIMPLE
    override val cost = 2.silver
    override val damage = 1.d6(BLUDGEONING)
    override val weight = 4.lb
    override val properties = setOf(Versatile(twoHandedDice = D8))
}

data object Mace : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = SIMPLE
    override val cost = 5.gold
    override val damage = 1.d6(BLUDGEONING)
    override val weight = 4.lb
}

data object Club : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = SIMPLE
    override val cost = 1.silver
    override val damage = 1.d4(BLUDGEONING)
    override val weight = 2.lb
    override val properties = setOf(Light)
}

data object Dagger : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = SIMPLE
    override val cost = 2.gold
    override val damage = 1.d4(PIERCING)
    override val weight = 1.lb
    override val properties = setOf(Light, Finesse, Thrown(shortRange = 20, longRange = 60))
}

data object Spear : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = SIMPLE
    override val cost = 1.gold
    override val damage = 1.d6(PIERCING)
    override val weight = 3.lb
    override val properties = setOf(Thrown(shortRange = 20, longRange = 60), Versatile(twoHandedDice = D8))
}

data object LightHammer : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = SIMPLE
    override val cost = 2.gold
    override val damage = 1.d4(BLUDGEONING)
    override val weight = 2.lb
    override val properties = setOf(Light, Thrown(shortRange = 20, longRange = 60))
}

data object Javelin : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = SIMPLE
    override val cost = 5.silver
    override val damage = 1.d6(PIERCING)
    override val weight = 2.lb
    override val properties = setOf(Thrown(shortRange = 30, longRange = 120))
}

data object Greatclub : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = SIMPLE
    override val cost = 2.silver
    override val damage = 1.d8(BLUDGEONING)
    override val weight = 10.lb
    override val properties = setOf(TwoHanded)
}

data object Handaxe : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = SIMPLE
    override val cost = 5.gold
    override val damage = 1.d6(SLASHING)
    override val weight = 2.lb
    override val properties = setOf(Light, Thrown(shortRange = 20, longRange = 60))
}

data object Sickle : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = SIMPLE
    override val cost = 1.gold
    override val damage = 1.d4(SLASHING)
    override val weight = 2.lb
    override val properties = setOf(Light)
}
