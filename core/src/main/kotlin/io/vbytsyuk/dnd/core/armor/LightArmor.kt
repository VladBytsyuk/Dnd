package io.vbytsyuk.dnd.core.armor

import io.vbytsyuk.dnd.core.armor.Armor.Type.Light
import io.vbytsyuk.dnd.core.units.gold
import io.vbytsyuk.dnd.core.units.minutes
import io.vbytsyuk.dnd.core.units.lb

object LeatherArmor : Armor {
    override val type = Light(armorClass = 11)
    override val cost = 10.gold
    override val weight = 10.lb
    override val hasStealthDisadvantage = false
    override val strengthRequirement = null
    override val timeToPutOn = 1.minutes
    override val timeToRemove = 1.minutes
}

object PaddedArmor : Armor {
    override val type = Light(armorClass = 11)
    override val cost = 5.gold
    override val weight = 8.lb
    override val hasStealthDisadvantage = true
    override val strengthRequirement = null
    override val timeToPutOn = 1.minutes
    override val timeToRemove = 1.minutes
}

object StuddedLeatherArmor : Armor {
    override val type = Light(armorClass = 12)
    override val cost = 45.gold
    override val weight = 13.lb
    override val hasStealthDisadvantage = false
    override val strengthRequirement = null
    override val timeToPutOn = 1.minutes
    override val timeToRemove = 1.minutes
}
