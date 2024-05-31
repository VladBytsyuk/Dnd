package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.units.feet
import io.vbytsyuk.dnd.core.units.Size

data object Human : Race(
    bonusStatBlock = StatBlock(
        strength = 1,
        dexterity = 1,
        constitution = 1,
        intelligence = 1,
        wisdom = 1,
        charisma = 1,
    ),
    size = Size.MEDIUM,
    baseSpeed = Speed(30.feet),
    darkVision = null,
)
