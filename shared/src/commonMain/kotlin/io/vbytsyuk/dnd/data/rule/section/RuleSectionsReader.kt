package io.vbytsyuk.dnd.data.rule.section

import io.vbytsyuk.dnd.data.FileNames
import io.vbytsyuk.dnd.data.ReaderImpl
import io.vbytsyuk.dnd.data.rule.section.json.RuleSectionJson
import io.vbytsyuk.dnd.data.rule.section.json.RuleSectionJsonParser
import io.vbytsyuk.dnd.data.rule.section.json.toDomain
import io.vbytsyuk.dnd.domain.rule.section.RuleSection

class RuleSectionsReader(
    jsonParser: RuleSectionJsonParser,
) : ReaderImpl<RuleSection, RuleSectionJson>(
    jsonParser = jsonParser,
    fileName = FileNames.RULE_SECTIONS,
    mapper = { it.toDomain() },
)
