package io.vbytsyuk.dnd.domain.core.race

import io.vbytsyuk.dnd.domain.core.StatBlock
import io.vbytsyuk.dnd.domain.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.core.units.AgeInfo
import io.vbytsyuk.dnd.domain.core.units.Distance
import io.vbytsyuk.dnd.domain.core.units.Names
import io.vbytsyuk.dnd.domain.core.units.Size
import io.vbytsyuk.dnd.domain.core.units.Speed
import io.vbytsyuk.dnd.domain.core.units.Trait
import io.vbytsyuk.dnd.domain.core.units.years

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
    val names: Names
        get() = Names(
        male = emptyList(),
        female = emptyList(),
        surnames = emptyList(),
        nicknames = emptyList(),
    )
}
