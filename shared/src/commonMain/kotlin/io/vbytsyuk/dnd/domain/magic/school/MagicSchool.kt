package io.vbytsyuk.dnd.domain.magic.school

import io.vbytsyuk.dnd.data.Id

data class MagicSchool(
    val id: Id,
    val name: String,
    val description: String,
    val url: String,
)
