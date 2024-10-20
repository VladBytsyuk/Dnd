package io.vbytsyuk.dnd.data.rule.base.json

import io.vbytsyuk.dnd.data.JsonParser
import kotlinx.serialization.json.Json

class RuleJsonParser(
    private val json: Json,
) : JsonParser<RuleJson> {

    override fun parse(jsonString: String): List<RuleJson> =
        json.decodeFromString<List<RuleJson>>(jsonString)
}
