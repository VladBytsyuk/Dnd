package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.sizie.Size

sealed class Race(
    val bonusStatBlock: StatBlock = StatBlock(),
    val size: Size,
    val baseSpeed: Speed,
)
