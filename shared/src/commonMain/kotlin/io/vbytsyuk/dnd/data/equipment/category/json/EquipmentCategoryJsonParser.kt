package io.vbytsyuk.dnd.data.equipment.category.json

import io.vbytsyuk.dnd.data.JsonParser
import kotlinx.serialization.json.Json

class EquipmentCategoryJsonParser(
    private val json: Json,
) : JsonParser<EquipmentCategoryJson> {

    override fun parse(jsonString: String): List<EquipmentCategoryJson> =
        json.decodeFromString<List<EquipmentCategoryJson>>(jsonString)
}
