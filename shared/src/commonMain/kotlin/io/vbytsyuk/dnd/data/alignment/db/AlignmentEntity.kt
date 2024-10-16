package io.vbytsyuk.dnd.data.alignment.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.alignment.Alignment

@Entity
data class AlignmentEntity(
    @PrimaryKey val id: Id,
    val name: String,
    val abbreviation: String,
    val description: String,
    val url: String,
)

fun AlignmentEntity.toDomain() = Alignment(
    id = id,
    name = name,
    abbreviation = abbreviation,
    description = description,
    url = url,
)

fun Alignment.toEntity() = AlignmentEntity(
    id = id,
    name = name,
    abbreviation = abbreviation,
    description = description,
    url = url,
)

fun List<AlignmentEntity>.toDomain() = map { it.toDomain() }

fun List<Alignment>.toEntity() = map { it.toEntity() }
