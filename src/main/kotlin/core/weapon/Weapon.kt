package io.vbytsyuk.dnd.core.weapon

import io.vbytsyuk.dnd.core.Damage
import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.money.Coins

open class Weapon(
    val rangeType: RangeType,
    val proficiencyType: ProficiencyType,
    val cost: Coins,
    val damage: Damage,
    val weight: Double,
    val properties: List<Property> = emptyList(),
) {

    enum class RangeType { MELEE, RANGED }
    enum class ProficiencyType { SIMPLE, MATRIAL }

    sealed class Property {
        data class Ammunition(val shortRange: Int, val longRange: Int) : Property()
        data object Finesse : Property()
        data object Heavy : Property()
        data object Light : Property()
        data object Loading : Property()
        data object Reach : Property()
        data object Reload : Property()
        data object Special : Property()
        data class Thrown(val shortRange: Int, val longRange: Int) : Property()
        data object TwoHanded : Property()
        data class Versatile(val twoHandedDice: Dice) : Property()
    }
}