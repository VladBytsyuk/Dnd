package io.vbytsyuk.dnd.domain.background

import io.vbytsyuk.dnd.data.Id

data class Background(
    val id: Id,
    val name: String,
    val languages: Int,
    val startingProficiencies: List<Id>,
    val startingEquipment: Map<Id, Double>,
    val startingEquipmentOptions: Map<Id, Int>,
    val feature: Feature,
    val personalityTraits: List<String>,
    val ideals: List<String>,
    val bonds: List<String>,
    val flaws: List<String>,
    val url: String,
) {

    data class Feature(
        val name: String,
        val description: List<String>,
    )
}
