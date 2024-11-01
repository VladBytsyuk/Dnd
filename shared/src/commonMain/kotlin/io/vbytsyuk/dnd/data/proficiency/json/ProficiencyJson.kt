package io.vbytsyuk.dnd.data.proficiency.json

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.proficiency.Proficiency
import kotlinx.serialization.Serializable

@Serializable
data class ProficiencyJson(
    val index: String,
    val type: String,
    val name: String,
    val classes: List<LinkJson>,
    val races: List<LinkJson>,
    val url: String,
    val reference: LinkJson,
) {

    @Serializable
    data class LinkJson(
        val index: String,
        val name: String,
        val url: String,
    )
}

fun ProficiencyJson.toDomain() = Proficiency(
    id = Id(index),
    type = type,
    name = name,
    classes = classes.map { Id(it.index) },
    races = races.map { Id(it.index) },
    url = url,
    reference = Id(reference.index),
)

fun List<ProficiencyJson>.toDomain() = map { it.toDomain() }
