package io.vbytsyuk.dnd.data.skill.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.ability.score.AbilityScore
import io.vbytsyuk.dnd.domain.skill.Skill

private const val SEPARATOR = "|"

@Entity
data class SkillEntity(
    @PrimaryKey val id: Id,
    val name: String,
    val description: String,
    val abilityScoreId: String,
    val url: String,
)

suspend fun SkillEntity.toDomain(mapper: suspend (Skill) -> Skill = { it }) = mapper(
    Skill(
        id = id,
        name = name,
        description = description.split(SEPARATOR),
        abilityScore = AbilityScore(id = Id(abilityScoreId)),
        url = url,
    )
)

fun Skill.toEntity() = SkillEntity(
    id = id,
    name = name,
    description = description.joinToString(SEPARATOR),
    abilityScoreId = abilityScore.id.value,
    url = url,
)

suspend fun List<SkillEntity>.toDomain(mapper: suspend (Skill) -> Skill = { it }) = map { mapper(it.toDomain()) }

fun List<Skill>.toEntity() = map { it.toEntity() }
