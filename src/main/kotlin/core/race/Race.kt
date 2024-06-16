package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.units.*

sealed class Race(
    val description: String? = null,
    val bonusStatBlock: StatBlock = StatBlock(),
    val size: Size,
    val ageInfo: AgeInfo = AgeInfo(mature = 0.years, limit = 100.years..100.years),
    val baseSpeed: Speed,
    val darkVision: Distance?,
    val proficiencies: Proficiencies,
    val alignmentRecommendation: String? = null,
    val feats: List<Feat> = emptyList(),
    val names: Names = Names(male = emptyList(), female = emptyList(), surnames = emptyList()),
)
