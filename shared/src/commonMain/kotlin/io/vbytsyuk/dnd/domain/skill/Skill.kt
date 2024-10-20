package io.vbytsyuk.dnd.domain.skill

import io.vbytsyuk.dnd.data.Id

data class Skill(
    val id: Id,
    val name: String,
    val description: List<String>,
    val abilityScoreId: Id,
    val url: String,
)
