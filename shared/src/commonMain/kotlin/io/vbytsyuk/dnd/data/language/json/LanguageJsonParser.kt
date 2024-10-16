package io.vbytsyuk.dnd.data.language.json

import io.vbytsyuk.dnd.data.JsonParser
import kotlinx.serialization.json.Json

class LanguageJsonParser(
    private val json: Json,
) : JsonParser<LanguageJson> {

    override fun parse(jsonString: String): List<LanguageJson> =
        json.decodeFromString<List<LanguageJson>>(jsonString)
}
