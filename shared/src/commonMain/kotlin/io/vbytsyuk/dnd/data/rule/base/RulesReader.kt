package io.vbytsyuk.dnd.data.rule.base

import io.vbytsyuk.dnd.data.FileNames
import io.vbytsyuk.dnd.data.ReaderImpl
import io.vbytsyuk.dnd.data.rule.base.json.RuleJson
import io.vbytsyuk.dnd.data.rule.base.json.RuleJsonParser
import io.vbytsyuk.dnd.data.rule.base.json.toDomain
import io.vbytsyuk.dnd.domain.rule.base.Rule

class RulesReader(
    jsonParser: RuleJsonParser,
) : ReaderImpl<Rule, RuleJson>(
    jsonParser = jsonParser,
    fileName = FileNames.RULES,
    mapper = { it.toDomain() },
)
