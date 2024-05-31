package io.vbytsyuk.dnd.core.armor

import io.vbytsyuk.dnd.core.armor.Armor.Type.Heavy
import io.vbytsyuk.dnd.core.units.gold
import io.vbytsyuk.dnd.core.units.minutes
import io.vbytsyuk.dnd.core.units.lb

object RingMail : Armor(
    type = Heavy(armorClass = 14),
    cost = 30.gold,
    weight = 40.lb,
    hasStealthDisadvantage = true,
    strengthRequirement = null,
    timeToPutOn = 10.minutes,
    timeToRemove = 5.minutes,
)

object ChainMail : Armor(
    type = Heavy(armorClass = 16),
    cost = 75.gold,
    weight = 55.lb,
    hasStealthDisadvantage = true,
    strengthRequirement = 13,
    timeToPutOn = 10.minutes,
    timeToRemove = 5.minutes,
)

object SplintArmor : Armor(
    type = Heavy(armorClass = 17),
    cost = 200.gold,
    weight = 60.lb,
    hasStealthDisadvantage = true,
    strengthRequirement = 15,
    timeToPutOn = 10.minutes,
    timeToRemove = 5.minutes,
)

object PlateArmor : Armor(
    type = Heavy(armorClass = 18),
    cost = 1500.gold,
    weight = 65.lb,
    hasStealthDisadvantage = true,
    strengthRequirement = 15,
    timeToPutOn = 10.minutes,
    timeToRemove = 5.minutes,
)
