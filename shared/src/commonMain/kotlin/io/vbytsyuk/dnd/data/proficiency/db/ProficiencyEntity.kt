package io.vbytsyuk.dnd.data.proficiency.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.proficiency.Proficiency

private const val SEPARATOR = "|"

@Entity
data class ProficiencyEntity(
    @PrimaryKey val id: Id,
    val type: String,
    val name: String,
    val classes: String,
    val races: String,
    val url: String,
    val reference: Id,
)

fun ProficiencyEntity.toDomain() = Proficiency(
    id = id,
    type = type,
    name = name,
    classes = classes.split(SEPARATOR).map(::Id),
    races = races.split(SEPARATOR).map(::Id),
    url = url,
    reference = reference,
)

fun Proficiency.toEntity() = ProficiencyEntity(
    id = id,
    type = type,
    name = name,
    classes = classes.joinToString(SEPARATOR) { it.value },
    races = races.joinToString(SEPARATOR) { it.value },
    url = url,
    reference = reference,
)

fun List<ProficiencyEntity>.toDomain() = map { it.toDomain() }

fun List<Proficiency>.toEntity() = map { it.toEntity() }
