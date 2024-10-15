package io.vbytsyuk.dnd.domain.core.armor

import io.vbytsyuk.dnd.domain.core.Modifier
import io.vbytsyuk.dnd.domain.core.StatValue
import io.vbytsyuk.dnd.domain.core.equipment.Item
import io.vbytsyuk.dnd.domain.core.units.Coins
import io.vbytsyuk.dnd.domain.core.units.Time

interface Armor : Item {

    val type: Type
    val cost: Coins
    val weight: io.vbytsyuk.dnd.domain.core.units.Weight
    val hasStealthDisadvantage: Boolean
    val strengthRequirement: StatValue?
    val timeToPutOn: Time
    val timeToRemove: Time

    override val name get() = this::class.simpleName.orEmpty()

    sealed class Type(val armorClass: StatValue) {
        abstract fun calculateAC(dexterityModifier: Modifier): StatValue

        class Light(armorClass: StatValue) : Type(armorClass) {
            override fun calculateAC(dexterityModifier: Modifier) =
                armorClass + dexterityModifier.value
        }

        class Medium(armorClass: StatValue) : Type(armorClass) {
            override fun calculateAC(dexterityModifier: Modifier) =
                armorClass + kotlin.math.max(2, dexterityModifier.value)
        }

        class Heavy(armorClass: StatValue) : Type(armorClass) {
            override fun calculateAC(dexterityModifier: Modifier) = armorClass
        }

        data object Shield : Type(armorClass = 0) {
            override fun calculateAC(dexterityModifier: Modifier): StatValue = 2
        }
    }
}
