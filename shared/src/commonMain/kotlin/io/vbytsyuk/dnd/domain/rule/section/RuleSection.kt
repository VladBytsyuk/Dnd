package io.vbytsyuk.dnd.domain.rule.section

import io.vbytsyuk.dnd.data.Id

data class RuleSection(
    val id: Id,
    val name: String,
    val description: String,
    val url: String,
)
