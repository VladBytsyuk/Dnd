package io.vbytsyuk.dnd.domain.equipment.base

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.units.ArmorClass
import io.vbytsyuk.dnd.domain.units.Cost
import io.vbytsyuk.dnd.domain.units.Damage
import io.vbytsyuk.dnd.domain.units.Range
import io.vbytsyuk.dnd.domain.units.Speed

sealed class Equipment(
    val id: Id,
    val name: String,
    val cost: Cost,
    val weight: Double,
    val description: List<String>,
    val url: String,
    val categoryId: Id,
) {
    override fun toString() = "${categoryId.value}:$name"

    class Weapon(
        id: Id,
        name: String,
        cost: Cost,
        weight: Double,
        description: List<String>,
        url: String,
        categoryId: Id,
        val weaponCategory: String,
        val weaponRange: String,
        val damage: Damage?,
        val range: Range,
        val throwRange: Range,
        val propertyIds: List<Id>,
    ) : Equipment(id, name, cost, weight, description, url, categoryId)

    class Armor(
        id: Id,
        name: String,
        cost: Cost,
        weight: Double,
        description: List<String>,
        url: String,
        categoryId: Id,
        val armorCategory: String,
        val armorClass: ArmorClass,
        val strengthMinimum: Int,
        val hasStealthDisadvantage: Boolean,
    ) : Equipment(id, name, cost, weight, description, url, categoryId)

    class AdventuringGear(
        id: Id,
        name: String,
        cost: Cost,
        weight: Double,
        description: List<String>,
        url: String,
        categoryId: Id,
        val gearCategoryId: Id,
        val quantity: Double,
        val contents: Map<Id, Int>,
    ) : Equipment(id, name, cost, weight, description, url, categoryId)

    class Tool(
        id: Id,
        name: String,
        cost: Cost,
        weight: Double,
        description: List<String>,
        url: String,
        categoryId: Id,
        val toolCategory: String,
    ) : Equipment(id, name, cost, weight, description, url, categoryId)

    class Transport(
        id: Id,
        name: String,
        cost: Cost,
        weight: Double,
        description: List<String>,
        url: String,
        categoryId: Id,
        val vehicleCategory: String,
        val speed: Speed,
        val capacity: String?,
    ) : Equipment(id, name, cost, weight, description, url, categoryId)

    class Custom(
        id: Id,
        name: String,
        cost: Cost,
        weight: Double,
        description: List<String>,
        url: String,
        categoryId: Id,
    ) : Equipment(id, name, cost, weight, description, url, categoryId)
}
