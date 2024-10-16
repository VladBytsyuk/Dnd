package io.vbytsyuk.dnd.domain.rule.section

import io.vbytsyuk.dnd.data.Id

data class RuleSection(
    val id: Id,
    val name: String,
    val description: String,
    val url: String,
) {

    constructor(id: Id) : this(id = id, name = "", description = "", url = "")

    val isEmpty: Boolean get() = name.isEmpty() && description.isEmpty() && url.isEmpty()
}
