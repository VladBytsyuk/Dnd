package io.vbytsyuk.dnd.core.armor

import io.vbytsyuk.dnd.core.armor.Armor.Type.Medium
import io.vbytsyuk.dnd.core.money.gold
import io.vbytsyuk.dnd.core.time.minutes
import io.vbytsyuk.dnd.core.weight.lb

object HideArmor : Armor(
    type = Medium(12),
    cost = 10.gold,
    weight = 12.lb,
    hasStealthDisadvantage = false,
    strengthRequirement = null,
    timeToPutOn = 5.minutes,
    timeToRemove = 1.minutes,
)

object ChainShirt : Armor(
    type = Medium(13),
    cost = 50.gold,
    weight = 20.lb,
    hasStealthDisadvantage = false,
    strengthRequirement = null,
    timeToPutOn = 5.minutes,
    timeToRemove = 1.minutes,
)

object ScaleMailArmor : Armor(
    type = Medium(14),
    cost = 50.gold,
    weight = 45.lb,
    hasStealthDisadvantage = true,
    strengthRequirement = null,
    timeToPutOn = 5.minutes,
    timeToRemove = 1.minutes,
)

object Breastplate : Armor(
    type = Medium(14),
    cost = 400.gold,
    weight = 20.lb,
    hasStealthDisadvantage = false,
    strengthRequirement = null,
    timeToPutOn = 5.minutes,
    timeToRemove = 1.minutes,
)

object SpikedArmor : Armor(
    type = Medium(14),
    cost = 75.gold,
    weight = 45.lb,
    hasStealthDisadvantage = true,
    strengthRequirement = null,
    timeToPutOn = 5.minutes,
    timeToRemove = 1.minutes,
)

object HalfPlateArmor : Armor(
    type = Medium(15),
    cost = 750.gold,
    weight = 40.lb,
    hasStealthDisadvantage = true,
    strengthRequirement = null,
    timeToPutOn = 5.minutes,
    timeToRemove = 1.minutes,
)
