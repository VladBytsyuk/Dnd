package io.vbytsyuk.dnd.data.magic.school.json

import io.vbytsyuk.dnd.data.JsonParser
import kotlinx.serialization.json.Json

class MagicSchoolJsonParser(
    private val json: Json,
) : JsonParser<MagicSchoolJson> {

    override fun parse(jsonString: String): List<MagicSchoolJson> =
        json.decodeFromString<List<MagicSchoolJson>>(jsonString)
}
