package io.vbytsyuk.dnd.domain.language

import io.vbytsyuk.dnd.data.Id

data class Language(
    val id: Id,
    val name: String,
    val description: String,
    val type: String,
    val typicalSpeakers: List<String>,
    val script: String,
    val url: String,
)
