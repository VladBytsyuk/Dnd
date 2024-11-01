package io.vbytsyuk.dnd.domain.proficiency

import io.vbytsyuk.dnd.data.Id

data class Proficiency(
    val id: Id,
    val type: String,
    val name: String,
    val classes: List<Id>,
    val races: List<Id>,
    val url: String,
    val reference: Id,
)
