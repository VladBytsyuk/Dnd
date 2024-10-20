package io.vbytsyuk.dnd.data.skill.json

import io.vbytsyuk.dnd.data.JsonParser
import kotlinx.serialization.json.Json

class SkillJsonParser(
    private val json: Json,
) : JsonParser<SkillJson> {

    override fun parse(jsonString: String): List<SkillJson> =
        json.decodeFromString<List<SkillJson>>(jsonString)
}
