package io.vbytsyuk.dnd.domain.weapon.property

import io.vbytsyuk.dnd.data.Id

data class WeaponProperty(
    val id: Id,
    val name: String,
    val description: List<String>,
    val url: String,
)
