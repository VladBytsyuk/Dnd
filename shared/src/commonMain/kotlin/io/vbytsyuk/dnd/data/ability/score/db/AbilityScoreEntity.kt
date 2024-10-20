package io.vbytsyuk.dnd.data.ability.score.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.ability.score.AbilityScore

private const val SEPARATOR = "|"

@Entity
data class AbilityScoreEntity(
    @PrimaryKey val id: Id,
    val shortName: String,
    val fullName: String,
    val description: String,
    val url: String,
)

fun AbilityScoreEntity.toDomain() = AbilityScore(
    id = id,
    shortName = shortName,
    fullName = fullName,
    description = description.split(SEPARATOR),
    url = url,
)

fun AbilityScore.toEntity() = AbilityScoreEntity(
    id = id,
    shortName = shortName,
    fullName = fullName,
    description = description.joinToString(SEPARATOR),
    url = url,
)

fun List<AbilityScoreEntity>.toDomain() = map { it.toDomain() }

fun List<AbilityScore>.toEntity() = map { it.toEntity() }
