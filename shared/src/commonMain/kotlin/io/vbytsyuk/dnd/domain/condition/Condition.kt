package io.vbytsyuk.dnd.domain.condition

import io.vbytsyuk.dnd.data.Id

data class Condition(
    val id: Id,
    val name: String,
    val description: String,
)
