@file:Suppress("MagicNumber") package io.vbytsyuk.dnd.domain.weapon

import io.vbytsyuk.dnd.domain.Dice.D10
import io.vbytsyuk.dnd.domain.Dice.D8
import io.vbytsyuk.dnd.domain.units.Damage.Type.BLUDGEONING
import io.vbytsyuk.dnd.domain.units.Damage.Type.PIERCING
import io.vbytsyuk.dnd.domain.units.Damage.Type.SLASHING
import io.vbytsyuk.dnd.domain.units.d10
import io.vbytsyuk.dnd.domain.units.d12
import io.vbytsyuk.dnd.domain.units.d4
import io.vbytsyuk.dnd.domain.units.d6
import io.vbytsyuk.dnd.domain.units.d8
import io.vbytsyuk.dnd.domain.units.gold
import io.vbytsyuk.dnd.domain.units.lb
import io.vbytsyuk.dnd.domain.weapon.Weapon.ProficiencyType.MATRIAL
import io.vbytsyuk.dnd.domain.weapon.Weapon.Property.Finesse
import io.vbytsyuk.dnd.domain.weapon.Weapon.Property.Heavy
import io.vbytsyuk.dnd.domain.weapon.Weapon.Property.Light
import io.vbytsyuk.dnd.domain.weapon.Weapon.Property.Reach
import io.vbytsyuk.dnd.domain.weapon.Weapon.Property.Special
import io.vbytsyuk.dnd.domain.weapon.Weapon.Property.TwoHanded
import io.vbytsyuk.dnd.domain.weapon.Weapon.Property.Versatile
import io.vbytsyuk.dnd.domain.weapon.Weapon.RangeType.MELEE

data object Halberd : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 20.gold
    override val damage = 1.d10(SLASHING)
    override val weight = 6.lb
    override val properties = setOf(TwoHanded, Reach, Heavy)
}

data object WarPick : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 5.gold
    override val damage = 1.d8(PIERCING)
    override val weight = 2.lb
}

data object Warhammer : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 15.gold
    override val damage = 1.d8(BLUDGEONING)
    override val weight = 2.lb
    override val properties = setOf(Versatile(twoHandedDice = D10))
}

data object Battleaxe : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 10.gold
    override val damage = 1.d8(SLASHING)
    override val weight = 4.lb
    override val properties = setOf(Versatile(twoHandedDice = D10))
}

data object Glaive : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 20.gold
    override val damage = 1.d10(SLASHING)
    override val weight = 6.lb
    override val properties = setOf(TwoHanded, Reach, Heavy)
}

data object Greatsword : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 50.gold
    override val damage = 2.d6(SLASHING)
    override val weight = 6.lb
    override val properties = setOf(TwoHanded, Heavy)
}

data object Lance : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 10.gold
    override val damage = 1.d12(PIERCING)
    override val weight = 6.lb
    override val properties = setOf(Reach, Special)
}

data object Longsword : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 15.gold
    override val damage = 1.d8(SLASHING)
    override val weight = 3.lb
    override val properties = setOf(Versatile(twoHandedDice = D10))
}

data object Whip : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 2.gold
    override val damage = 1.d4(SLASHING)
    override val weight = 3.lb
    override val properties = setOf(Reach, Finesse)
}

data object Shortsword : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 10.gold
    override val damage = 1.d6(PIERCING)
    override val weight = 2.lb
    override val properties = setOf(Light, Finesse)
}

data object Maul : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 10.gold
    override val damage = 2.d6(BLUDGEONING)
    override val weight = 10.lb
    override val properties = setOf(TwoHanded, Heavy)
}

data object Morningstar : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 15.gold
    override val damage = 1.d8(PIERCING)
    override val weight = 4.lb
}

data object Pike : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 5.gold
    override val damage = 1.d10(PIERCING)
    override val weight = 18.lb
    override val properties = setOf(TwoHanded, Reach, Heavy)
}

data object Rapier : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 25.gold
    override val damage = 1.d8(PIERCING)
    override val weight = 2.lb
    override val properties = setOf(Finesse)
}

data object Greataxe : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 30.gold
    override val damage = 1.d12(SLASHING)
    override val weight = 7.lb
    override val properties = setOf(TwoHanded, Heavy)
}

data object Scimitar : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 25.gold
    override val damage = 1.d6(SLASHING)
    override val weight = 3.lb
    override val properties = setOf(Light, Finesse)
}

data object Trident : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 5.gold
    override val damage = 1.d6(PIERCING)
    override val weight = 4.lb
    override val properties = setOf(
        Weapon.Property.Thrown(shortRange = 20, longRange = 60),
        Versatile(twoHandedDice = D8),
    )
}

data object Flail : Weapon {
    override val rangeType = MELEE
    override val proficiencyType = MATRIAL
    override val cost = 10.gold
    override val damage = 1.d8(BLUDGEONING)
    override val weight = 2.lb
}
