package io.vbytsyuk.dnd.domain.race

import io.vbytsyuk.dnd.domain.StatBlock
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.units.AgeInfo
import io.vbytsyuk.dnd.domain.units.Distance
import io.vbytsyuk.dnd.domain.units.Names
import io.vbytsyuk.dnd.domain.units.Size
import io.vbytsyuk.dnd.domain.units.Speed
import io.vbytsyuk.dnd.domain.units.Trait
import io.vbytsyuk.dnd.domain.units.years

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
