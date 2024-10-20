package io.vbytsyuk.dnd.domain.ability.score

import io.vbytsyuk.dnd.data.Id

data class AbilityScore(
    val id: Id,
    val shortName: String,
    val fullName: String,
    val description: List<String>,
    val url: String,
) {

    constructor(id: Id) : this(id = id, shortName = "", fullName = "", description = emptyList(), url = "")

    val isEmpty: Boolean get() = shortName.isEmpty() && fullName.isEmpty() && description.isEmpty() && url.isEmpty()
}
