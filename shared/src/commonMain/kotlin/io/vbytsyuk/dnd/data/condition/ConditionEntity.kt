package io.vbytsyuk.dnd.data.condition

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.condition.Condition

@Entity
data class ConditionEntity(
    @PrimaryKey val id: Id,
    val name: String,
    val description: String,
)

fun ConditionEntity.toDomain() = Condition(
    id = id,
    name = name,
    description = description,
)

fun Condition.toEntity() = ConditionEntity(
    id = id,
    name = name,
    description = description,
)

fun List<ConditionEntity>.toDomain() = map { it.toDomain() }
