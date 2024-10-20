package io.vbytsyuk.dnd.domain.rule.base

import io.vbytsyuk.dnd.data.Id

data class Rule(
    val id: Id,
    val name: String,
    val description: String,
    val subSectionIds: List<Id>,
    val url: String,
)
