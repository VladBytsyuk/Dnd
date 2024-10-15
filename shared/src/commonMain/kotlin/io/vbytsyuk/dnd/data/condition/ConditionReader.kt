package io.vbytsyuk.dnd.data.condition

import io.vbytsyuk.dnd.data.JsonParser
import io.vbytsyuk.dnd.domain.condition.Condition
import io.vbytsyuk.dnd.domain.condition.Reader
import io.vbytsyuk.dnd.readFileAsString

class ConditionReader(
    private val conditionJsonParser: JsonParser<ConditionJson>,
) : Reader<Condition> {

    override fun read(): List<Condition> {
        val stringJson = readFileAsString(CONDITIONS_FILENAME)
        val conditionJsonList = conditionJsonParser.parse(stringJson)
        return conditionJsonList.toDomain()
    }

    companion object {
        private const val CONDITIONS_FILENAME = "phb/5e-SRD-Conditions.json"
    }
}
