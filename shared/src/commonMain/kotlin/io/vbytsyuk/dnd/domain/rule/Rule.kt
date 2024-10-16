package io.vbytsyuk.dnd.domain.rule

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.rule.section.RuleSection

data class Rule(
    val id: Id,
    val name: String,
    val description: String,
    val subSections: List<RuleSection>,
    val url: String,
)
