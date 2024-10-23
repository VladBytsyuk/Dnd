package io.vbytsyuk.dnd.data.background.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.background.Background
import io.vbytsyuk.dnd.domain.background.Background.Feature

private const val SEPARATOR = "|"
private const val MAP_SEPARATOR = ":"

@Entity
data class BackgroundEntity(
    @PrimaryKey val id: Id,
    val name: String,
    val languages: Int,
    val startingProficiencies: String,
    val startingEquipment: String,
    val startingEquipmentOptions: String,
    val featureName: String,
    val featureDescription: String,
    val personalityTraits: String,
    val ideals: String,
    val bonds: String,
    val flaws: String,
    val url: String,
)

fun BackgroundEntity.toDomain() = Background(
    id = id,
    name = name,
    languages = languages,
    startingProficiencies = startingProficiencies.split(SEPARATOR).map(::Id),
    startingEquipment = startingEquipment.split(SEPARATOR).associate {
        val entry = it.split(MAP_SEPARATOR)
        Id(entry.first()) to entry.last().toDouble()
    },
    startingEquipmentOptions = startingEquipmentOptions.split(SEPARATOR).associate {
        val entry = it.split(MAP_SEPARATOR)
        Id(entry.first()) to entry.last().toInt()
    },
    feature = Feature(
        name = featureName,
        description = featureDescription.split(SEPARATOR),
    ),
    personalityTraits = personalityTraits.split(SEPARATOR),
    ideals = ideals.split(SEPARATOR),
    bonds = bonds.split(SEPARATOR),
    flaws = flaws.split(SEPARATOR),
    url = url,
)

fun Background.toEntity() = BackgroundEntity(
    id = id,
    name = name,
    languages = languages,
    startingProficiencies = startingProficiencies.joinToString(SEPARATOR),
    startingEquipment = startingEquipment.toList()
        .joinToString(SEPARATOR) { "\"${it.first.value}$MAP_SEPARATOR${it.second}\"" },
    startingEquipmentOptions = startingEquipmentOptions.toList()
        .joinToString(SEPARATOR) { "\"${it.first.value}$MAP_SEPARATOR${it.second}\"" },
    featureName = feature.name,
    featureDescription = feature.description.joinToString(SEPARATOR),
    personalityTraits = personalityTraits.joinToString(SEPARATOR),
    ideals = ideals.joinToString(SEPARATOR),
    bonds = bonds.joinToString(SEPARATOR),
    flaws = flaws.joinToString(SEPARATOR),
    url = url,
)

fun List<BackgroundEntity>.toDomain() = map { it.toDomain() }

fun List<Background>.toEntity() = map { it.toEntity() }
