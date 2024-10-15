package io.vbytsyuk.dnd.data.damage.type.json

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.damage.type.DamageType
import kotlinx.serialization.Serializable

@Serializable
data class DamageTypeJson(
    val index: String,
    val name: String,
    val desc: List<String>,
    val url: String,
)

fun DamageTypeJson.toDomain() = DamageType(
    id = Id(index),
    name = name,
    description = desc,
    url = url,
)

fun List<DamageTypeJson>.toDomain() = map { it.toDomain() }
