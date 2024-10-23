package io.vbytsyuk.dnd.data.background.json

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.background.Background
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BackgroundJson(
    val index: String,
    val name: String,
    @SerialName("starting_proficiencies") val startingProficiencies: List<LinkJson>,
    @SerialName("language_options") val languageOptions: OptionsJson? = null,
    @SerialName("starting_equipment") val startingEquipment: List<StartingEquipmentJson>,
    @SerialName("starting_equipment_options") val startingEquipmentOptions: List<OptionsJson>,
    val feature: FeatureJson,
    @SerialName("personality_traits") val personalityTraits: OptionsJson,
    val ideals: OptionsJson,
    val bonds: OptionsJson,
    val flaws: OptionsJson,
    val url: String,
) {

    @Serializable
    data class LinkJson(
        val index: String,
        val name: String,
        val url: String,
    )

    @Serializable
    data class OptionsJson(
        val choose: Int,
        val type: String,
        val from: FromJson,
    )

    @Serializable
    data class StartingEquipmentJson(
        val equipment: LinkJson,
        val quantity: Double,
    )

    @Serializable
    data class FeatureJson(
        val name: String,
        val desc: List<String>,
    )

    @Serializable
    data class FromJson(
        @SerialName("option_set_type") val optionSetType: String,
        @SerialName("resource_list_url") val resourceListUrl: String? = null,
        @SerialName("equipment_category") val equipmentCategory: LinkJson? = null,
        val options: List<TraitsOptionsJson>? = null,
    )

    @Serializable
    data class TraitsOptionsJson(
        @SerialName("option_type") val optionType: String,
        val string: String? = null,
        val desc: String? = null,
        val alignments: List<LinkJson>? = null,
    )
}

fun BackgroundJson.toDomain() = Background(
    id = Id(index),
    name = name,
    languages = languageOptions?.choose ?: 0,
    startingProficiencies = startingProficiencies.map { Id(it.index) },
    startingEquipment = startingEquipment.associate { Id(it.equipment.index) to it.quantity },
    startingEquipmentOptions = startingEquipmentOptions
        .associate { Id(it.from.equipmentCategory?.index.orEmpty()) to it.choose },
    feature = Background.Feature(
        name = feature.name,
        description = feature.desc,
    ),
    personalityTraits = personalityTraits.from.options?.map { it.string.orEmpty() }.orEmpty(),
    ideals = ideals.from.options
        ?.map { option -> "${option.desc.orEmpty()} (${option.alignments?.joinToString { it.name }.orEmpty()})" }
        .orEmpty(),
    bonds = bonds.from.options?.map { it.string.orEmpty() }.orEmpty(),
    flaws = flaws.from.options?.map { it.string.orEmpty() }.orEmpty(),
    url = url,
)

fun List<BackgroundJson>.toDomain() = map { it.toDomain() }
