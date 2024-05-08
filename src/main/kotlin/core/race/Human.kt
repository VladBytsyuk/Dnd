package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.StatBlock

data object Human : Race(
    bonusStatBlock = StatBlock(
        strength = 1,
        dexterity = 1,
        constitution = 1,
        intelligence = 1,
        wisdom = 1,
        charisma = 1,
    ),
)
