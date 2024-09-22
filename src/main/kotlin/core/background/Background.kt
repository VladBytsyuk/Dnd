package io.vbytsyuk.dnd.core.background

import io.vbytsyuk.dnd.core.equipment.Equipment
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.units.Coins
import io.vbytsyuk.dnd.core.units.GoodVsEvil
import io.vbytsyuk.dnd.core.units.LawVsChaos

interface Background {

    val description: String

    val proficiencies: Proficiencies
    val startCoins: Coins
    val equipment: Equipment
    val features: List<Feature> get() = emptyList()
    val suggestedCharacteristics: SuggestedCharacteristics

    data class Feature(
        val name: String,
        val description: String,
    )

    data class SuggestedCharacteristics(
        val description: String,
        val personalityTraits: List<Statement>,
        val ideals: List<Statement>,
        val bonds: List<Statement>,
        val flaws: List<Statement>,
    )

    class Statement private constructor(
        val value: String,
        val goodVsEvil: GoodVsEvil? = null,
        val lawVsChaos: LawVsChaos? = null,
    ) {
        constructor(value: String) :
            this(value = value, goodVsEvil = null, lawVsChaos = null)

        constructor(value: String, goodVsEvil: GoodVsEvil) :
            this(value = value, goodVsEvil = goodVsEvil, lawVsChaos = null)

        constructor(value: String, lawVsChaos: LawVsChaos) :
            this(value = value, goodVsEvil = null, lawVsChaos = lawVsChaos)
    }
}
