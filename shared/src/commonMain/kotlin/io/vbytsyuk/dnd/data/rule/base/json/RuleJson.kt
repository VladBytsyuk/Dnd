package io.vbytsyuk.dnd.data.rule.base.json

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.rule.base.Rule
import kotlinx.serialization.Serializable

@Serializable
data class RuleJson(
    val index: String,
    val name: String,
    val desc: String,
    val url: String,
    val subsections: List<SubSection>,
) {

    @Serializable
    data class SubSection(
        val index: String,
        val name: String,
        val url: String,
    )
}

fun RuleJson.toDomain() = Rule(
    id = Id(index),
    name = name,
    description = desc,
    url = url,
    subSectionIds = subsections.map { Id(it.index) }
)

fun List<RuleJson>.toDomain() = map { it.toDomain() }
