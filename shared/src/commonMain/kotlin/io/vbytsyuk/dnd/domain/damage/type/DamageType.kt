package io.vbytsyuk.dnd.domain.damage.type

import io.vbytsyuk.dnd.data.Id

data class DamageType(
    val id: Id,
    val name: String,
    val description: List<String>,
    val url: String,
)
