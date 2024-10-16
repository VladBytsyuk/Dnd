package io.vbytsyuk.dnd.data.rule.section.json

import io.vbytsyuk.dnd.data.JsonParser
import kotlinx.serialization.json.Json

class RuleSectionJsonParser(
    private val json: Json,
) : JsonParser<RuleSectionJson> {

    override fun parse(jsonString: String): List<RuleSectionJson> =
        json.decodeFromString<List<RuleSectionJson>>(jsonString)
}
