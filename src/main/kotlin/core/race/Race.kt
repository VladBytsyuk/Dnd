package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.units.Distance
import io.vbytsyuk.dnd.core.units.Size

sealed class Race(
    val bonusStatBlock: StatBlock = StatBlock(),
    val size: Size,
    val baseSpeed: Speed,
    val darkVision: Distance?,
)
