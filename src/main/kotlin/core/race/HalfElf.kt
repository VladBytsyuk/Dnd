package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.Stat
import io.vbytsyuk.dnd.core.StatBlock

data class HalfElf(
    val chosenStat1: Stat,
    val chosenStat2: Stat,
) : Race(
    bonusStatBlock = StatBlock(charisma = 2).applyChosenStats(chosenStat1, chosenStat2)
)