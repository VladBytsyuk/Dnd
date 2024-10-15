package io.vbytsyuk.dnd.data.condition

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.condition.Condition
import kotlinx.serialization.Serializable

@Serializable
data class ConditionJson(
    val id: String,
    val name: String,
    val description: String,
)

fun ConditionJson.toDomain() = Condition(
    id = Id(id),
    name = name,
    description = description,
)

fun Condition.toJson() = ConditionJson(
    id = id.value,
    name = name,
    description = description,
)

fun List<ConditionJson>.toDomain() = map { it.toDomain() }
