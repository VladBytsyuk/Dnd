package io.vbytsyuk.dnd.data.ability.score.json

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.ability.score.AbilityScore
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilityScoreJson(
    val index: String,
    val name: String,
    @SerialName("full_name") val fullName: String,
    val desc: List<String>,
    val url: String,
    val skills: List<Skills>,
) {

    @Serializable
    data class Skills(
        val index: String,
        val name: String,
        val url: String
    )
}

fun AbilityScoreJson.toDomain() = AbilityScore(
    id = Id(index),
    shortName = name,
    fullName = fullName,
    description = desc,
    url = url,
    skillIds = skills.map { Id(it.index) }
)

fun List<AbilityScoreJson>.toDomain() = map { it.toDomain() }
