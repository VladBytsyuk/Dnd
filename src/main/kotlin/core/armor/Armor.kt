package io.vbytsyuk.dnd.core.armor

import io.vbytsyuk.dnd.core.Modifier
import io.vbytsyuk.dnd.core.StatValue
import io.vbytsyuk.dnd.core.equipment.Item
import io.vbytsyuk.dnd.core.units.Coins
import io.vbytsyuk.dnd.core.units.Time
import io.vbytsyuk.dnd.core.units.Weight

open class Armor(
    val type: Type,
    val cost: Coins,
    val weight: Weight,
    val hasStealthDisadvantage: Boolean,
    val strengthRequirement: StatValue? = null,
    val timeToPutOn: Time,
    val timeToRemove: Time,
) : Item {

    override val name = this::class.simpleName.orEmpty()

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