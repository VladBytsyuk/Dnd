package io.vbytsyuk.dnd.data.weapon.property.json

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.weapon.property.WeaponProperty
import kotlinx.serialization.Serializable

@Serializable
data class WeaponPropertyJson(
    val index: String,
    val name: String,
    val desc: List<String>,
    val url: String,
)

fun WeaponPropertyJson.toDomain() = WeaponProperty(
    id = Id(index),
    name = name,
    description = desc,
    url = url,
)

fun List<WeaponPropertyJson>.toDomain() = map { it.toDomain() }
