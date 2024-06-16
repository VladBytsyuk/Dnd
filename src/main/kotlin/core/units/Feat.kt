package io.vbytsyuk.dnd.core.units

import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Skills

data class Feat(
    val name: String,
    val description: String,
    val affect: Affect = Affect(),
)

data class Affect(
    val savingThrows: List<StatType> = emptyList(),
    val skills: Skills = Skills(),
    val spells: Map<Spell, StatType> = emptyMap(),
)
