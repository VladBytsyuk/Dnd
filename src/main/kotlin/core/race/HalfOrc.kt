package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.StatBlock

data object HalfOrc : Race(
    bonusStatBlock = StatBlock(strength = 2, constitution = 1),
)