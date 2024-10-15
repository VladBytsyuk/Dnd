package io.vbytsyuk.dnd.data.condition.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.condition.Condition

private const val SEPARATOR = "|"

@Entity
data class ConditionEntity(
    @PrimaryKey val id: Id,
    val name: String,
    val description: String,
    val url: String,
)

fun ConditionEntity.toDomain() = Condition(
    id = id,
    name = name,
    description = description.split(SEPARATOR),
    url = url,
)

fun Condition.toEntity() = ConditionEntity(
    id = id,
    name = name,
    description = description.joinToString(SEPARATOR),
    url = url,
)

fun List<ConditionEntity>.toDomain() = map { it.toDomain() }

fun List<Condition>.toEntity() = map { it.toEntity() }
