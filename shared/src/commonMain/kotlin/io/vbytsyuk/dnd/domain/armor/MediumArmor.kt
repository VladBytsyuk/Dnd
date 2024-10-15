@file:Suppress("MagicNumber") package io.vbytsyuk.dnd.domain.armor

import io.vbytsyuk.dnd.domain.armor.Armor.Type.Medium
import io.vbytsyuk.dnd.domain.units.gold
import io.vbytsyuk.dnd.domain.units.lb
import io.vbytsyuk.dnd.domain.units.minutes

object HideArmor : Armor {
    override val type = Medium(12)
    override val cost = 10.gold
    override val weight = 12.lb
    override val hasStealthDisadvantage = false
    override val strengthRequirement = null
    override val timeToPutOn = 5.minutes
    override val timeToRemove = 1.minutes
}

object ChainShirt : Armor {
    override val type = Medium(13)
    override val cost = 50.gold
    override val weight = 20.lb
    override val hasStealthDisadvantage = false
    override val strengthRequirement = null
    override val timeToPutOn = 5.minutes
    override val timeToRemove = 1.minutes
}

object ScaleMailArmor : Armor {
    override val type = Medium(14)
    override val cost = 50.gold
    override val weight = 45.lb
    override val hasStealthDisadvantage = true
    override val strengthRequirement = null
    override val timeToPutOn = 5.minutes
    override val timeToRemove = 1.minutes
}

object Breastplate : Armor {
    override val type = Medium(14)
    override val cost = 400.gold
    override val weight = 20.lb
    override val hasStealthDisadvantage = false
    override val strengthRequirement = null
    override val timeToPutOn = 5.minutes
    override val timeToRemove = 1.minutes
}

object SpikedArmor : Armor {
    override val type = Medium(14)
    override val cost = 75.gold
    override val weight = 45.lb
    override val hasStealthDisadvantage = true
    override val strengthRequirement = null
    override val timeToPutOn = 5.minutes
    override val timeToRemove = 1.minutes
}

object HalfPlateArmor : Armor {
    override val type = Medium(15)
    override val cost = 750.gold
    override val weight = 40.lb
    override val hasStealthDisadvantage = true
    override val strengthRequirement = null
    override val timeToPutOn = 5.minutes
    override val timeToRemove = 1.minutes
}
