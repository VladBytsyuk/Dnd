package io.vbytsyuk.dnd.data.equipment.base.json

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.data.equipment.base.EQUIPMENT_CATEGORY_ID_ADVENTURING_GEAR
import io.vbytsyuk.dnd.data.equipment.base.EQUIPMENT_CATEGORY_ID_ARMOR
import io.vbytsyuk.dnd.data.equipment.base.EQUIPMENT_CATEGORY_ID_TOOL
import io.vbytsyuk.dnd.data.equipment.base.EQUIPMENT_CATEGORY_ID_TRANSPORT
import io.vbytsyuk.dnd.data.equipment.base.EQUIPMENT_CATEGORY_ID_WEAPON
import io.vbytsyuk.dnd.domain.equipment.base.Equipment
import io.vbytsyuk.dnd.domain.units.ArmorClass
import io.vbytsyuk.dnd.domain.units.Cost
import io.vbytsyuk.dnd.domain.units.Damage
import io.vbytsyuk.dnd.domain.units.Range
import io.vbytsyuk.dnd.domain.units.Speed
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EquipmentJson(
    val index: String,
    val name: String,
    val url: String,
    val cost: CostJson,
    val weight: Double? = null,
    val desc: List<String>? = null,
    @SerialName("equipment_category") val equipmentCategory: LinkJson,
    @SerialName("weapon_category") val weaponCategory: String? = null,
    @SerialName("weapon_range") val weaponRange: String? = null,
    @SerialName("category_range") val categoryRange: String? = null,
    val damage: DamageJson? = null,
    val range: RangeJson? = null,
    @SerialName("throw_range") val throwRange: RangeJson? = null,
    val properties: List<LinkJson>? = null,
    @SerialName("armor_category") val armorCategory: String? = null,
    @SerialName("armor_class") val armorClass: ArmorClassJson? = null,
    @SerialName("str_minimum") val strMinimum: Int? = null,
    @SerialName("stealth_disadvantage") val stealthDisadvantage: Boolean? = null,
    @SerialName("gear_category") val gearCategory: LinkJson? = null,
    val quantity: Double? = null,
    val contents: List<ContentJson>? = null,
    @SerialName("tool_category") val toolCategory: String? = null,
    @SerialName("vehicle_category") val vehicleCategory: String? = null,
    val speed: SpeedJson? = null,
    val capacity: String? = null,
) {

    @Serializable
    data class LinkJson(
        val index: String,
        val name: String,
        val url: String,
    )

    @Serializable
    data class CostJson(
        val quantity: Int,
        val unit: String,
    )

    @Serializable
    data class SpeedJson(
        val quantity: Double,
        val unit: String,
    )

    @Serializable
    data class RangeJson(
        val normal: Int,
        val long: Int? = null,
    )

    @Serializable
    data class DamageJson(
        @SerialName("damage_dice") val dice: String,
        @SerialName("damage_type") val type: LinkJson,
    )

    @Serializable
    data class ArmorClassJson(
        @SerialName("base") val base: Int,
        @SerialName("dex_bonus") val dexBonus: Boolean,
        @SerialName("max_bonus") val maxBonus: Int? = null,
    )

    @Serializable
    data class ContentJson(
        val item: LinkJson,
        val quantity: Int,
    )
}

fun EquipmentJson.toDomain() = when (equipmentCategory.index) {
    EQUIPMENT_CATEGORY_ID_WEAPON -> toWeaponDomain()
    EQUIPMENT_CATEGORY_ID_ARMOR -> toArmorDomain()
    EQUIPMENT_CATEGORY_ID_ADVENTURING_GEAR -> toAdventuringGearDomain()
    EQUIPMENT_CATEGORY_ID_TOOL -> toToolDomain()
    EQUIPMENT_CATEGORY_ID_TRANSPORT -> toTransportDomain()
    else -> toCustomDomain()
}

private fun EquipmentJson.toWeaponDomain(): Equipment.Weapon {
    val dice = damage?.dice
    val typeId = damage?.type?.index
    val damage = if (dice != null && typeId != null) Damage(dice = dice, typeId = Id(typeId)) else null
    return Equipment.Weapon(
        id = Id(index),
        name = name,
        cost = Cost(quantity = cost.quantity, unit = cost.unit),
        weight = weight ?: 0.0,
        description = desc.orEmpty(),
        url = url,
        categoryId = Id(equipmentCategory.index),
        weaponCategory = weaponCategory.orEmpty(),
        weaponRange = weaponRange.orEmpty(),
        damage = damage,
        range = Range(normal = range?.normal ?: 0, long = range?.long),
        throwRange = Range(normal = throwRange?.normal ?: 0, long = throwRange?.long),
        propertyIds = properties?.map { Id(it.index) }.orEmpty(),
    )
}

private fun EquipmentJson.toArmorDomain(): Equipment.Armor = Equipment.Armor(
    id = Id(index),
    name = name,
    cost = Cost(quantity = cost.quantity, unit = cost.unit),
    weight = weight ?: 0.0,
    description = desc.orEmpty(),
    url = url,
    categoryId = Id(equipmentCategory.index),
    armorCategory = armorCategory.orEmpty(),
    armorClass = ArmorClass(
        base = armorClass?.base ?: 0,
        hasDexBonus = armorClass?.dexBonus ?: false,
        maxBonus = armorClass?.maxBonus ?: 0,
    ),
    strengthMinimum = strMinimum ?: 0,
    hasStealthDisadvantage = stealthDisadvantage ?: false,
)

private fun EquipmentJson.toAdventuringGearDomain(): Equipment.AdventuringGear = Equipment.AdventuringGear(
    id = Id(index),
    name = name,
    cost = Cost(quantity = cost.quantity, unit = cost.unit),
    weight = weight ?: 0.0,
    description = desc.orEmpty(),
    url = url,
    categoryId = Id(equipmentCategory.index),
    gearCategoryId = Id(gearCategory?.index.orEmpty()),
    quantity = quantity ?: 0.0,
    contents = contents?.associate { Id(it.item.index) to it.quantity }.orEmpty(),
)

private fun EquipmentJson.toToolDomain(): Equipment.Tool = Equipment.Tool(
    id = Id(index),
    name = name,
    cost = Cost(quantity = cost.quantity, unit = cost.unit),
    weight = weight ?: 0.0,
    description = desc.orEmpty(),
    url = url,
    categoryId = Id(equipmentCategory.index),
    toolCategory = toolCategory.orEmpty(),
)

private fun EquipmentJson.toTransportDomain(): Equipment.Transport = Equipment.Transport(
    id = Id(index),
    name = name,
    cost = Cost(quantity = cost.quantity, unit = cost.unit),
    weight = weight ?: 0.0,
    description = desc.orEmpty(),
    url = url,
    categoryId = Id(equipmentCategory.index),
    vehicleCategory = vehicleCategory.orEmpty(),
    speed = Speed(
        quantity = speed?.quantity ?: 0.0,
        unit = speed?.unit.orEmpty(),
    ),
    capacity = capacity,
)

private fun EquipmentJson.toCustomDomain(): Equipment.Custom = Equipment.Custom(
    id = Id(index),
    name = name,
    cost = Cost(quantity = cost.quantity, unit = cost.unit),
    weight = weight ?: 0.0,
    description = desc.orEmpty(),
    url = url,
    categoryId = Id(equipmentCategory.index),
)

fun List<EquipmentJson>.toDomain() = map { it.toDomain() }
