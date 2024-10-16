package io.vbytsyuk.dnd.data.rule.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.rule.Rule
import io.vbytsyuk.dnd.domain.rule.section.RuleSection

private const val SEPARATOR = "|"

@Entity
data class RuleEntity(
    @PrimaryKey val id: Id,
    val name: String,
    val description: String,
    val subSectionsIds: String,
    val url: String,
)

suspend fun RuleEntity.toDomain(mapper: suspend (Rule) -> Rule = { it }) = mapper(
    Rule(
        id = id,
        name = name,
        description = description,
        subSections = subSectionsIds.split(SEPARATOR).map { RuleSection(id = Id(it)) },
        url = url,
    )
)

fun Rule.toEntity() = RuleEntity(
    id = id,
    name = name,
    description = description,
    subSectionsIds = subSections.joinToString(SEPARATOR) { it.id.value },
    url = url,
)

suspend fun List<RuleEntity>.toDomain(mapper: suspend (Rule) -> Rule = { it }) = map { mapper(it.toDomain()) }

fun List<Rule>.toEntity() = map { it.toEntity() }
