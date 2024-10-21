package io.vbytsyuk.dnd.domain.units

import io.vbytsyuk.dnd.data.Id

data class Damage(
    val dice: String,
    val typeId: Id,
)
