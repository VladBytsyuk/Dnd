package io.vbytsyuk.dnd.domain

import io.vbytsyuk.dnd.domain.condition.Condition
import io.vbytsyuk.dnd.domain.damage.type.DamageType

data class Rulebook(
    val conditions: List<Condition>,
    val damageTypes: List<DamageType>,
)
