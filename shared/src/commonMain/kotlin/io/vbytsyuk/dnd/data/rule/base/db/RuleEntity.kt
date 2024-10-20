package io.vbytsyuk.dnd.data.rule.base.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.rule.base.Rule

private const val SEPARATOR = "|"

@Entity
data class RuleEntity(
    @PrimaryKey val id: Id,
    val name: String,
    val description: String,
    val subSectionsIds: String,
    val url: String,
)

fun RuleEntity.toDomain() = Rule(
    id = id,
    name = name,
    description = description,
    subSectionIds = subSectionsIds.split(SEPARATOR).map(::Id),
    url = url,
)

fun Rule.toEntity() = RuleEntity(
    id = id,
    name = name,
    description = description,
    subSectionsIds = subSectionIds.joinToString(SEPARATOR) { it.value },
    url = url,
)

fun List<RuleEntity>.toDomain() = map { it.toDomain() }

fun List<Rule>.toEntity() = map { it.toEntity() }
