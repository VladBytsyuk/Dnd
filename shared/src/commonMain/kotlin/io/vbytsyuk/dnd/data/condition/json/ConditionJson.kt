package io.vbytsyuk.dnd.data.condition.json

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.condition.Condition
import kotlinx.serialization.Serializable

@Serializable
data class ConditionJson(
    val index: String,
    val name: String,
    val desc: List<String>,
    val url: String,
)

fun ConditionJson.toDomain() = Condition(
    id = Id(index),
    name = name,
    description = desc,
    url = url,
)

fun List<ConditionJson>.toDomain() = map { it.toDomain() }
