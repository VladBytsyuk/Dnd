package io.vbytsyuk.dnd.data.equipment.category

import io.vbytsyuk.dnd.data.FileNames
import io.vbytsyuk.dnd.data.ReaderImpl
import io.vbytsyuk.dnd.data.equipment.category.json.EquipmentCategoryJson
import io.vbytsyuk.dnd.data.equipment.category.json.EquipmentCategoryJsonParser
import io.vbytsyuk.dnd.data.equipment.category.json.toDomain
import io.vbytsyuk.dnd.domain.equipment.category.EquipmentCategory

class EquipmentCategoriesReader(
    jsonParser: EquipmentCategoryJsonParser,
) : ReaderImpl<EquipmentCategory, EquipmentCategoryJson>(
    jsonParser = jsonParser,
    fileName = FileNames.EQUIPMENT_CATEGORIES,
    mapper = { it.toDomain() },
)
