package io.vbytsyuk.dnd.domain.equipment.category

import io.vbytsyuk.dnd.data.Id

data class EquipmentCategory(
    val id: Id,
    val name: String,
    val equipmentIds: List<Id>,
    val url: String,
)
