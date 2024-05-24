package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.StatType

data class HalfElf(
    val chosenStat1: StatType,
    val chosenStat2: StatType,
) : Race(
    bonusStatBlock = StatBlock(charisma = 2).applyChosenStats(chosenStat1, chosenStat2)
)