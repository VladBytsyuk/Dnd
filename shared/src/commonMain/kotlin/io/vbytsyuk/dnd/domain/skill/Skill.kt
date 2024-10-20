package io.vbytsyuk.dnd.domain.skill

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.ability.score.AbilityScore

data class Skill(
    val id: Id,
    val name: String,
    val description: List<String>,
    val abilityScore: AbilityScore,
    val url: String,
)
