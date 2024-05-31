package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.units.feet
import io.vbytsyuk.dnd.core.units.Size

data object HalfOrc : Race(
    bonusStatBlock = StatBlock(strength = 2, constitution = 1),
    size = Size.MEDIUM,
    baseSpeed = Speed(30.feet),
)