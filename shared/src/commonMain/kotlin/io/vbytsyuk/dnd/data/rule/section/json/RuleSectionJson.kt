package io.vbytsyuk.dnd.data.rule.section.json

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.rule.section.RuleSection
import kotlinx.serialization.Serializable

@Serializable
data class RuleSectionJson(
    val index: String,
    val name: String,
    val desc: String,
    val url: String,
)

fun RuleSectionJson.toDomain() = RuleSection(
    id = Id(index),
    name = name,
    description = desc,
    url = url,
)

fun List<RuleSectionJson>.toDomain() = map { it.toDomain() }
