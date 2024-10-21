package io.vbytsyuk.dnd.data.equipment.base.json

import io.vbytsyuk.dnd.data.JsonParser
import kotlinx.serialization.json.Json

class EquipmentJsonParser(
    private val json: Json,
) : JsonParser<EquipmentJson> {

    override fun parse(jsonString: String): List<EquipmentJson> =
        json.decodeFromString<List<EquipmentJson>>(jsonString)
}
