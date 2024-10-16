package io.vbytsyuk.dnd.data.rule

import io.vbytsyuk.dnd.data.FileNames
import io.vbytsyuk.dnd.data.ReaderImpl
import io.vbytsyuk.dnd.data.rule.json.RuleJson
import io.vbytsyuk.dnd.data.rule.json.RuleJsonParser
import io.vbytsyuk.dnd.data.rule.json.toDomain
import io.vbytsyuk.dnd.domain.rule.Rule

class RulesReader(
    jsonParser: RuleJsonParser,
) : ReaderImpl<Rule, RuleJson>(
    jsonParser = jsonParser,
    fileName = FileNames.RULES,
    mapper = { it.toDomain() },
)
