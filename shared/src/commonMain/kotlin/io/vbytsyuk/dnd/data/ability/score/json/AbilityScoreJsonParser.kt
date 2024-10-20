package io.vbytsyuk.dnd.data.ability.score.json

import io.vbytsyuk.dnd.data.JsonParser
import kotlinx.serialization.json.Json

class AbilityScoreJsonParser(
    private val json: Json,
) : JsonParser<AbilityScoreJson> {

    override fun parse(jsonString: String): List<AbilityScoreJson> =
        json.decodeFromString<List<AbilityScoreJson>>(jsonString)
}
