package io.vbytsyuk.dnd.data.equipment.base.db

import androidx.room.Entity
import androidx.room.PrimaryKey
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

private const val SEPARATOR = "|"
private const val MAP_SEPARATOR = ":"

@Entity
data class EquipmentEntity(
    @PrimaryKey val id: Id,
    val name: String,
    val costQuantity: Int,
    val costUnit: String,
    val weight: Double,
    val description: String? = null,
    val url: String,
    val categoryId: Id,
    val weaponCategory: String? = null,
    val weaponRange: String? = null,
    val weaponDamageDice: String? = null,
    val weaponDamageTypeId: Id? = null,
    val weaponAttackRangeNormal: Int? = null,
    val weaponAttackRangeLong: Int? = null,
    val weaponThrowRangeNormal: Int? = null,
    val weaponThrowRangeLong: Int? = null,
    val weaponPropertiesIds: String? = null,
    val armorCategory: String? = null,
    val armorClassBase: Int? = null,
    val armorClassHasDexBonus: Boolean? = null,
    val armorClassMaxBonus: Int? = null,
    val armorStrengthMinimum: Int? = null,
    val armorHasStealthDisadvantage: Boolean? = null,
    val adventuringGearCategoryId: Id? = null,
    val adventuringGearQuantity: Double? = null,
    val adventuringGearContents: String? = null,
    val toolCategory: String? = null,
    val transportCategory: String? = null,
    val transportSpeedQuantity: Double? = null,
    val transportSpeedUnit: String? = null,
    val transportCapacity: String? = null,
)

fun EquipmentEntity.toDomain() = when (categoryId.value) {
    EQUIPMENT_CATEGORY_ID_WEAPON -> toWeaponDomain()
    EQUIPMENT_CATEGORY_ID_ARMOR -> toArmorDomain()
    EQUIPMENT_CATEGORY_ID_ADVENTURING_GEAR -> toAdventuringGearDomain()
    EQUIPMENT_CATEGORY_ID_TOOL -> toToolDomain()
    EQUIPMENT_CATEGORY_ID_TRANSPORT -> toTransportDomain()
    else -> toCustomDomain()
}

private fun EquipmentEntity.toWeaponDomain(): Equipment.Weapon {
    val dice = weaponDamageDice
    val typeId = weaponDamageTypeId
    val damage = if (dice != null && typeId != null) Damage(dice = dice, typeId = typeId) else null
    return Equipment.Weapon(
        id = id,
        name = name,
        cost = Cost(quantity = costQuantity, unit = costUnit),
        weight = weight,
        description = description?.split(SEPARATOR).orEmpty(),
        url = url,
        categoryId = categoryId,
        weaponCategory = weaponCategory.orEmpty(),
        weaponRange = weaponRange.orEmpty(),
        damage = damage,
        range = Range(normal = weaponAttackRangeNormal ?: 0, long = weaponAttackRangeLong),
        throwRange = Range(normal = weaponThrowRangeNormal ?: 0, long = weaponThrowRangeLong),
        propertyIds = weaponPropertiesIds?.split(SEPARATOR)?.map(::Id).orEmpty(),
    )
}

private fun EquipmentEntity.toArmorDomain(): Equipment.Armor = Equipment.Armor(
    id = id,
    name = name,
    cost = Cost(quantity = costQuantity, unit = costUnit),
    weight = weight,
    description = description?.split(SEPARATOR).orEmpty(),
    url = url,
    categoryId = categoryId,
    armorCategory = armorCategory.orEmpty(),
    armorClass = ArmorClass(
        base = armorClassBase ?: 0,
        hasDexBonus = armorClassHasDexBonus ?: false,
        maxBonus = armorClassMaxBonus ?: 0,
    ),
    strengthMinimum = armorStrengthMinimum ?: 0,
    hasStealthDisadvantage = armorHasStealthDisadvantage ?: false,
)

private fun EquipmentEntity.toAdventuringGearDomain(): Equipment.AdventuringGear = Equipment.AdventuringGear(
    id = id,
    name = name,
    cost = Cost(quantity = costQuantity, unit = costUnit),
    weight = weight,
    description = description?.split(SEPARATOR).orEmpty(),
    url = url,
    categoryId = categoryId,
    gearCategoryId = adventuringGearCategoryId ?: Id(value = ""),
    quantity = adventuringGearQuantity ?: 0.0,
    contents = adventuringGearContents?.split(SEPARATOR)?.associate {
        val entry = it.split(MAP_SEPARATOR)
        Id(entry.first()) to entry.last().toInt()
    } ?: emptyMap(),
)

private fun EquipmentEntity.toToolDomain(): Equipment.Tool = Equipment.Tool(
    id = id,
    name = name,
    cost = Cost(quantity = costQuantity, unit = costUnit),
    weight = weight,
    description = description?.split(SEPARATOR).orEmpty(),
    url = url,
    categoryId = categoryId,
    toolCategory = toolCategory.orEmpty(),
)

private fun EquipmentEntity.toTransportDomain(): Equipment.Transport = Equipment.Transport(
    id = id,
    name = name,
    cost = Cost(quantity = costQuantity, unit = costUnit),
    weight = weight,
    description = description?.split(SEPARATOR).orEmpty(),
    url = url,
    categoryId = categoryId,
    vehicleCategory = transportCategory.orEmpty(),
    speed = Speed(
        quantity = transportSpeedQuantity ?: 0.0,
        unit = transportSpeedUnit.orEmpty(),
    ),
    capacity = transportCapacity,
)

private fun EquipmentEntity.toCustomDomain(): Equipment.Custom = Equipment.Custom(
    id = id,
    name = name,
    cost = Cost(quantity = costQuantity, unit = costUnit),
    weight = weight,
    description = description?.split(SEPARATOR).orEmpty(),
    url = url,
    categoryId = categoryId,
)

fun Equipment.toEntity() = when (this) {
    is Equipment.Weapon -> toWeaponEntity()
    is Equipment.Armor -> toArmorEntity()
    is Equipment.AdventuringGear -> toAdventuringGearEntity()
    is Equipment.Tool -> toToolEntity()
    is Equipment.Transport -> toTransportEntity()
    is Equipment.Custom -> toCustomEntity()
}

private fun Equipment.Weapon.toWeaponEntity() = EquipmentEntity(
    id = id,
    name = name,
    costQuantity = cost.quantity,
    costUnit = cost.unit,
    weight = weight,
    description = description.joinToString(SEPARATOR),
    url = url,
    categoryId = categoryId,
    weaponCategory = weaponCategory,
    weaponRange = weaponRange,
    weaponDamageDice = damage?.dice,
    weaponDamageTypeId = damage?.typeId,
    weaponAttackRangeNormal = range.normal,
    weaponAttackRangeLong = range.long,
    weaponThrowRangeNormal = throwRange.normal,
    weaponThrowRangeLong = throwRange.long,
    weaponPropertiesIds = propertyIds.joinToString(SEPARATOR) { it.value },
)

private fun Equipment.Armor.toArmorEntity() = EquipmentEntity(
    id = id,
    name = name,
    costQuantity = cost.quantity,
    costUnit = cost.unit,
    weight = weight,
    description = description.joinToString(SEPARATOR),
    url = url,
    categoryId = categoryId,
    armorCategory = armorCategory,
    armorClassBase = armorClass.base,
    armorClassHasDexBonus = armorClass.hasDexBonus,
    armorClassMaxBonus = armorClass.maxBonus,
    armorStrengthMinimum = strengthMinimum,
    armorHasStealthDisadvantage = hasStealthDisadvantage,
)

private fun Equipment.AdventuringGear.toAdventuringGearEntity() = EquipmentEntity(
    id = id,
    name = name,
    costQuantity = cost.quantity,
    costUnit = cost.unit,
    weight = weight,
    description = description.joinToString(SEPARATOR),
    url = url,
    categoryId = categoryId,
    adventuringGearCategoryId = gearCategoryId,
    adventuringGearQuantity = quantity,
    adventuringGearContents = contents.toList()
        .joinToString(SEPARATOR) { "${it.first.value}$MAP_SEPARATOR${it.second}" },
)

private fun Equipment.Tool.toToolEntity() = EquipmentEntity(
    id = id,
    name = name,
    costQuantity = cost.quantity,
    costUnit = cost.unit,
    weight = weight,
    description = description.joinToString(SEPARATOR),
    url = url,
    categoryId = categoryId,
    toolCategory = toolCategory,
)

private fun Equipment.Transport.toTransportEntity() = EquipmentEntity(
    id = id,
    name = name,
    costQuantity = cost.quantity,
    costUnit = cost.unit,
    weight = weight,
    description = description.joinToString(SEPARATOR),
    url = url,
    categoryId = categoryId,
    transportCategory = vehicleCategory,
    transportSpeedQuantity = speed.quantity,
    transportSpeedUnit = speed.unit,
    transportCapacity = capacity,
)

private fun Equipment.Custom.toCustomEntity() = EquipmentEntity(
    id = id,
    name = name,
    costQuantity = cost.quantity,
    costUnit = cost.unit,
    weight = weight,
    description = description.joinToString(SEPARATOR),
    url = url,
    categoryId = categoryId,
)

fun List<EquipmentEntity>.toDomain() = map { it.toDomain() }

fun List<Equipment>.toEntity() = map { it.toEntity() }
