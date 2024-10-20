package io.vbytsyuk.dnd.data.skill.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.data.Id
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

fun SkillEntity.toDomain() = Skill(
    id = id,
    name = name,
    description = description.split(SEPARATOR),
    abilityScoreId = Id(abilityScoreId),
    url = url,
)

fun Skill.toEntity() = SkillEntity(
    id = id,
    name = name,
    description = description.joinToString(SEPARATOR),
    abilityScoreId = abilityScoreId.value,
    url = url,
)

fun List<SkillEntity>.toDomain() = map { it.toDomain() }

fun List<Skill>.toEntity() = map { it.toEntity() }
