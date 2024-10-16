package io.vbytsyuk.dnd.data.language.json

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.language.Language
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LanguageJson(
    val index: String,
    val name: String,
    val desc: String? = null,
    val type: String,
    @SerialName("typical_speakers") val typicalSpeakers: List<String>,
    val script: String? = null,
    val url: String,
)

fun LanguageJson.toDomain() = Language(
    id = Id(index),
    name = name,
    description = desc.orEmpty(),
    type = type,
    typicalSpeakers = typicalSpeakers,
    script = script.orEmpty(),
    url = url,
)

fun List<LanguageJson>.toDomain() = map { it.toDomain() }
