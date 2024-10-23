package io.vbytsyuk.dnd.data.background.json

import io.vbytsyuk.dnd.data.JsonParser
import kotlinx.serialization.json.Json

class BackgroundJsonParser(
    private val json: Json,
) : JsonParser<BackgroundJson> {

    override fun parse(jsonString: String): List<BackgroundJson> =
        json.decodeFromString<List<BackgroundJson>>(jsonString)
}
