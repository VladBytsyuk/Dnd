@file:Suppress("MagicNumber") package io.vbytsyuk.dnd.domain.weapon

import io.vbytsyuk.dnd.domain.Dice.D8
import io.vbytsyuk.dnd.domain.units.Damage.Type.BLUDGEONING
import io.vbytsyuk.dnd.domain.units.Damage.Type.PIERCING
import io.vbytsyuk.dnd.domain.units.Damage.Type.SLASHING
import io.vbytsyuk.dnd.domain.units.d4
import io.vbytsyuk.dnd.domain.units.d6
import io.vbytsyuk.dnd.domain.units.d8
import io.vbytsyuk.dnd.domain.units.gold
import io.vbytsyuk.dnd.domain.units.lb
import io.vbytsyuk.dnd.domain.units.silver
import io.vbytsyuk.dnd.domain.weapon.Weapon.ProficiencyType.SIMPLE
import io.vbytsyuk.dnd.domain.weapon.Weapon.Property.Finesse
import io.vbytsyuk.dnd.domain.weapon.Weapon.Property.Light
import io.vbytsyuk.dnd.domain.weapon.Weapon.Property.Thrown
import io.vbytsyuk.dnd.domain.weapon.Weapon.Property.TwoHanded
import io.vbytsyuk.dnd.domain.weapon.Weapon.Property.Versatile
import io.vbytsyuk.dnd.domain.weapon.Weapon.RangeType.MELEE

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
