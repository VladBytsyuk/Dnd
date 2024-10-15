package io.vbytsyuk.dnd.domain.core.units


data class Names(
    val male: List<String>,
    val female: List<String>,
    val surnames: List<String>,
    val nicknames: List<String> = emptyList(),
)
