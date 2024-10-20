package io.vbytsyuk.dnd.data.equipment.category.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.equipment.category.EquipmentCategory

private const val SEPARATOR = "|"

@Entity
data class EquipmentCategoryEntity(
    @PrimaryKey val id: Id,
    val name: String,
    val equipmentIds: String,
    val url: String,
)

fun EquipmentCategoryEntity.toDomain() = EquipmentCategory(
    id = id,
    name = name,
    equipmentIds = equipmentIds.split(SEPARATOR).map(::Id),
    url = url,
)

fun EquipmentCategory.toEntity() = EquipmentCategoryEntity(
    id = id,
    name = name,
    equipmentIds = equipmentIds.joinToString(SEPARATOR) { it.value },
    url = url,
)

fun List<EquipmentCategoryEntity>.toDomain() = map { it.toDomain() }

fun List<EquipmentCategory>.toEntity() = map { it.toEntity() }
