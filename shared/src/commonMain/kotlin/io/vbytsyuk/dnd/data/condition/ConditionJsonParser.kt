package io.vbytsyuk.dnd.data.condition

import io.vbytsyuk.dnd.data.JsonParser
import kotlinx.serialization.json.Json

class ConditionJsonParser : JsonParser<ConditionJson> {

    override fun parse(jsonString: String): List<ConditionJson> =
        Json.decodeFromString<List<ConditionJson>>(jsonString)
}
