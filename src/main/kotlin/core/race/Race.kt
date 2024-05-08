package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.StatBlock

sealed class Race(
    val bonusStatBlock: StatBlock = StatBlock(),
)
