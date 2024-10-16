package io.vbytsyuk.dnd.data.language.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.language.Language

private const val SEPARATOR = "|"

@Entity
data class LanguageEntity(
    @PrimaryKey val id: Id,
    val name: String,
    val description: String,
    val type: String,
    val typicalSpeakers: String,
    val script: String,
    val url: String,
)

fun LanguageEntity.toDomain() = Language(
    id = id,
    name = name,
    description = description,
    type = type,
    typicalSpeakers = typicalSpeakers.split(SEPARATOR),
    script = script,
    url = url,
)

fun Language.toEntity() = LanguageEntity(
    id = id,
    name = name,
    description = description,
    type = type,
    typicalSpeakers = typicalSpeakers.joinToString(SEPARATOR),
    script = script,
    url = url,
)

fun List<LanguageEntity>.toDomain() = map { it.toDomain() }

fun List<Language>.toEntity() = map { it.toEntity() }
