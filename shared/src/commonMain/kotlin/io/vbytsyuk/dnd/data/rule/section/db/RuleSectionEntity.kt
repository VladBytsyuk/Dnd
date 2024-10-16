package io.vbytsyuk.dnd.data.rule.section.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.rule.section.RuleSection

@Entity
data class RuleSectionEntity(
    @PrimaryKey val id: Id,
    val name: String,
    val description: String,
    val url: String,
)

fun RuleSectionEntity.toDomain() = RuleSection(
    id = id,
    name = name,
    description = description,
    url = url,
)

fun RuleSection.toEntity() = RuleSectionEntity(
    id = id,
    name = name,
    description = description,
    url = url,
)

fun List<RuleSectionEntity>.toDomain() = map { it.toDomain() }

fun List<RuleSection>.toEntity() = map { it.toEntity() }
