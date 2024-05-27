package io.vbytsyuk.dnd.core.armor

import io.vbytsyuk.dnd.core.armor.Armor.Type.Light
import io.vbytsyuk.dnd.core.money.gold
import io.vbytsyuk.dnd.core.time.minutes
import io.vbytsyuk.dnd.core.weight.lb

object LeatherArmor : Armor(
    type = Light(armorClass = 11),
    cost = 10.gold,
    weight = 10.lb,
    hasStealthDisadvantage = false,
    strengthRequirement = null,
    timeToPutOn = 1.minutes,
    timeToRemove = 1.minutes,
)

object PaddedArmor : Armor(
    type = Light(armorClass = 11),
    cost = 5.gold,
    weight = 8.lb,
    hasStealthDisadvantage = true,
    strengthRequirement = null,
    timeToPutOn = 1.minutes,
    timeToRemove = 1.minutes,
)

object StuddedLeatherArmor : Armor(
    type = Light(armorClass = 12),
    cost = 45.gold,
    weight = 13.lb,
    hasStealthDisadvantage = false,
    strengthRequirement = null,
    timeToPutOn = 1.minutes,
    timeToRemove = 1.minutes,
)
