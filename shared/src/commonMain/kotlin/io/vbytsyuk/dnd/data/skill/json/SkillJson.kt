package io.vbytsyuk.dnd.data.skill.json

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.ability.score.AbilityScore
import io.vbytsyuk.dnd.domain.skill.Skill
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SkillJson(
    val index: String,
    val name: String,
    val desc: List<String>,
    val url: String,
    @SerialName("ability_score") val abilityScore: AbilityScore,
) {

    @Serializable
    data class AbilityScore(
        val index: String,
        val name: String,
        val url: String,
    )
}

fun SkillJson.toDomain() = Skill(
    id = Id(index),
    name = name,
    description = desc,
    url = url,
    abilityScoreId = Id(abilityScore.index),
)

fun List<SkillJson>.toDomain() = map { it.toDomain() }
