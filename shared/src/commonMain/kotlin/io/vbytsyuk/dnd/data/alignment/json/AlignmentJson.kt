package io.vbytsyuk.dnd.data.alignment.json

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.alignment.Alignment
import kotlinx.serialization.Serializable

@Serializable
data class AlignmentJson(
    val index: String,
    val name: String,
    val abbreviation: String,
    val desc: String,
    val url: String,
)

fun AlignmentJson.toDomain() = Alignment(
    id = Id(index),
    name = name,
    abbreviation = abbreviation,
    description = desc,
    url = url,
)

fun List<AlignmentJson>.toDomain() = map { it.toDomain() }
