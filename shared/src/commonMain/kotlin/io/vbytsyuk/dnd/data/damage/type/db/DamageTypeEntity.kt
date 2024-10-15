package io.vbytsyuk.dnd.data.damage.type.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.damage.type.DamageType

private const val SEPARATOR = "|"

@Entity
data class DamageTypeEntity(
    @PrimaryKey val id: Id,
    val name: String,
    val description: String,
    val url: String,
)

fun DamageTypeEntity.toDomain() = DamageType(
    id = id,
    name = name,
    description = description.split(SEPARATOR),
    url = url,
)

fun DamageType.toEntity() = DamageTypeEntity(
    id = id,
    name = name,
    description = description.joinToString(SEPARATOR),
    url = url,
)

fun List<DamageTypeEntity>.toDomain() = map { it.toDomain() }

fun List<DamageType>.toEntity() = map { it.toEntity() }
