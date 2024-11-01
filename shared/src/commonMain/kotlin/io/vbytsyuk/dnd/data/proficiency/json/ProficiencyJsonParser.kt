package io.vbytsyuk.dnd.data.proficiency.json

import io.vbytsyuk.dnd.data.JsonParser
import kotlinx.serialization.json.Json

class ProficiencyJsonParser(
    private val json: Json,
) : JsonParser<ProficiencyJson> {

    override fun parse(jsonString: String): List<ProficiencyJson> =
        json.decodeFromString<List<ProficiencyJson>>(jsonString)
}
