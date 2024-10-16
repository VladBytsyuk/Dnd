package io.vbytsyuk.dnd.domain.alignment

import io.vbytsyuk.dnd.data.Id

data class Alignment(
    val id: Id,
    val name: String,
    val abbreviation: String,
    val description: String,
    val url: String,
)
