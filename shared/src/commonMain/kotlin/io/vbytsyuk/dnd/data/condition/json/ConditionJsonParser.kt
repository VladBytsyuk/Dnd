package io.vbytsyuk.dnd.data.condition.json

import io.vbytsyuk.dnd.data.JsonParser
import kotlinx.serialization.json.Json

class ConditionJsonParser(
    private val json: Json,
) : JsonParser<ConditionJson> {

    override fun parse(jsonString: String): List<ConditionJson> =
        json.decodeFromString<List<ConditionJson>>(jsonString)
}
