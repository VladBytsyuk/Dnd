package io.vbytsyuk.dnd.data.equipment.category.json

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.equipment.category.EquipmentCategory
import kotlinx.serialization.Serializable

@Serializable
data class EquipmentCategoryJson(
    val index: String,
    val name: String,
    val equipment: List<Equipment>,
    val url: String,
) {

    @Serializable
    data class Equipment(
        val index: String,
        val name: String,
        val url: String,
    )
}

fun EquipmentCategoryJson.toDomain() = EquipmentCategory(
    id = Id(index),
    name = name,
    equipmentIds = equipment.map { Id(it.index) },
    url = url,
)

fun List<EquipmentCategoryJson>.toDomain() = map { it.toDomain() }
