package io.vbytsyuk.dnd.data.alignment.json

import io.vbytsyuk.dnd.data.JsonParser
import kotlinx.serialization.json.Json

class AlignmentJsonParser(
    private val json: Json,
) : JsonParser<AlignmentJson> {

    override fun parse(jsonString: String): List<AlignmentJson> =
        json.decodeFromString<List<AlignmentJson>>(jsonString)
}
