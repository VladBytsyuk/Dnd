package io.vbytsyuk.dnd.data.weapon.property.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.weapon.property.WeaponProperty

private const val SEPARATOR = "|"

@Entity
data class WeaponPropertyEntity(
    @PrimaryKey val id: Id,
    val name: String,
    val description: String,
    val url: String,
)

fun WeaponPropertyEntity.toDomain() = WeaponProperty(
    id = id,
    name = name,
    description = description.split(SEPARATOR),
    url = url,
)

fun WeaponProperty.toEntity() = WeaponPropertyEntity(
    id = id,
    name = name,
    description = description.joinToString(SEPARATOR),
    url = url,
)

fun List<WeaponPropertyEntity>.toDomain() = map { it.toDomain() }

fun List<WeaponProperty>.toEntity() = map { it.toEntity() }
