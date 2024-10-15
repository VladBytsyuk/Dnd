package io.vbytsyuk.dnd.data.condition

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.condition.Condition
import kotlinx.serialization.Serializable

private const val SEPARATOR = ","

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
    description = desc.joinToString(separator = SEPARATOR),
    url = url,
)

fun List<ConditionJson>.toDomain() = map { it.toDomain() }
