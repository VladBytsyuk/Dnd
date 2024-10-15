@file:Suppress("MagicNumber") package io.vbytsyuk.dnd.domain.armor

import io.vbytsyuk.dnd.domain.armor.Armor.Type.Heavy
import io.vbytsyuk.dnd.domain.units.gold
import io.vbytsyuk.dnd.domain.units.lb
import io.vbytsyuk.dnd.domain.units.minutes

object RingMail : Armor {
    override val type = Heavy(armorClass = 14)
    override val cost = 30.gold
    override val weight = 40.lb
    override val hasStealthDisadvantage = true
    override val strengthRequirement = null
    override val timeToPutOn = 10.minutes
    override val timeToRemove = 5.minutes
}

object ChainMail : Armor {
    override val type = Heavy(armorClass = 16)
    override val cost = 75.gold
    override val weight = 55.lb
    override val hasStealthDisadvantage = true
    override val strengthRequirement = 13
    override val timeToPutOn = 10.minutes
    override val timeToRemove = 5.minutes
}

object SplintArmor : Armor {
    override val type = Heavy(armorClass = 17)
    override val cost = 200.gold
    override val weight = 60.lb
    override val hasStealthDisadvantage = true
    override val strengthRequirement = 15
    override val timeToPutOn = 10.minutes
    override val timeToRemove = 5.minutes
}

object PlateArmor : Armor {
    override val type = Heavy(armorClass = 18)
    override val cost = 1500.gold
    override val weight = 65.lb
    override val hasStealthDisadvantage = true
    override val strengthRequirement = 15
    override val timeToPutOn = 10.minutes
    override val timeToRemove = 5.minutes
}
