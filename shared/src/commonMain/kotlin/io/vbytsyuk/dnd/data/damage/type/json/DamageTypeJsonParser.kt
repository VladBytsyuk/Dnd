package io.vbytsyuk.dnd.data.damage.type.json

import io.vbytsyuk.dnd.data.JsonParser
import kotlinx.serialization.json.Json

class DamageTypeJsonParser(
    private val json: Json,
) : JsonParser<DamageTypeJson> {

    override fun parse(jsonString: String): List<DamageTypeJson> =
        json.decodeFromString<List<DamageTypeJson>>(jsonString)
}
