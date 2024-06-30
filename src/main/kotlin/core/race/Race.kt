package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.units.*

interface Race {
    val description: String get() = ""
    val bonusStatBlock: StatBlock
    val size: Size
    val baseSpeed: Speed
    val darkVision: Distance? get() = null
    val proficiencies: Proficiencies
    val traits: List<Trait> get() = emptyList()
    val ageInfo: AgeInfo get() = AgeInfo(0.years, 0.years)
    val alignmentRecommendation: String get() = ""
    val names: Names get() = Names(
        male = emptyList(),
        female = emptyList(),
        surnames = emptyList(),
        nicknames = emptyList(),
    )
}
