package io.vbytsyuk.dnd.data.condition

import io.vbytsyuk.dnd.data.JsonParser
import io.vbytsyuk.dnd.domain.condition.Condition
import io.vbytsyuk.dnd.readFileAsString
import kotlinx.serialization.json.Json

class ConditionParser : JsonParser<Condition> {

    override fun parse(fileName: String): List<Condition> {
        val stringJson = readFileAsString(fileName)
        val conditionJsonList = Json.decodeFromString<List<ConditionJson>>(stringJson)
        return conditionJsonList.toDomain()
    }
}
