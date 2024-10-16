package io.vbytsyuk.dnd.data.magic.school.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.magic.school.MagicSchool

@Entity
data class MagicSchoolEntity(
    @PrimaryKey val id: Id,
    val name: String,
    val description: String,
    val url: String,
)

fun MagicSchoolEntity.toDomain() = MagicSchool(
    id = id,
    name = name,
    description = description,
    url = url,
)

fun MagicSchool.toEntity() = MagicSchoolEntity(
    id = id,
    name = name,
    description = description,
    url = url,
)

fun List<MagicSchoolEntity>.toDomain() = map { it.toDomain() }

fun List<MagicSchool>.toEntity() = map { it.toEntity() }
