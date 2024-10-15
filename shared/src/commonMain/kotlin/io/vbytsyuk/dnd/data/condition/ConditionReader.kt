package io.vbytsyuk.dnd.data.condition

import io.vbytsyuk.dnd.data.FileNames
import io.vbytsyuk.dnd.data.ReaderImpl
import io.vbytsyuk.dnd.data.condition.json.ConditionJson
import io.vbytsyuk.dnd.data.condition.json.ConditionJsonParser
import io.vbytsyuk.dnd.data.condition.json.toDomain
import io.vbytsyuk.dnd.domain.condition.Condition

class ConditionReader(
    jsonParser: ConditionJsonParser,
) : ReaderImpl<Condition, ConditionJson>(
    jsonParser = jsonParser,
    fileName = FileNames.CONDITIONS,
    mapper = { it.toDomain() },
)
