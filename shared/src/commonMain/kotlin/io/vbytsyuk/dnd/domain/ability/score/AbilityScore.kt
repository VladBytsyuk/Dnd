package io.vbytsyuk.dnd.domain.ability.score

import io.vbytsyuk.dnd.data.Id

data class AbilityScore(
    val id: Id,
    val shortName: String,
    val fullName: String,
    val description: List<String>,
    val url: String,
)
