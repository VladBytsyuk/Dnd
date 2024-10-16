package io.vbytsyuk.dnd.data.magic.school.json

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.magic.school.MagicSchool
import kotlinx.serialization.Serializable

@Serializable
data class MagicSchoolJson(
    val index: String,
    val name: String,
    val desc: String,
    val url: String,
)

fun MagicSchoolJson.toDomain() = MagicSchool(
    id = Id(index),
    name = name,
    description = desc,
    url = url,
)

fun List<MagicSchoolJson>.toDomain() = map { it.toDomain() }
