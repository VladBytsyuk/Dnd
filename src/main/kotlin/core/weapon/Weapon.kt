package io.vbytsyuk.dnd.core.weapon

import io.vbytsyuk.dnd.core.units.Damage
import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.equipment.Item
import io.vbytsyuk.dnd.core.units.Coins
import io.vbytsyuk.dnd.core.units.Weight

interface Weapon : Item {

    val rangeType: RangeType
    val proficiencyType: ProficiencyType
    val cost: Coins
    val damage: Damage
    val weight: Weight
    val properties: Set<Property> get() = emptySet()

    override val name get() = this::class.simpleName.orEmpty()

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