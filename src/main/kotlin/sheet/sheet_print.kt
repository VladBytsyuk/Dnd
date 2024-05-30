package io.vbytsyuk.dnd.sheet

fun Sheet.print() = buildString {
    appendLine("----------------------------------")
    append("${character.name}, ")
    appendLine("${character.race::class.simpleName} ${character.level} ${character.`class`::class.simpleName}")
    appendLine("${character.statBlock}")
    appendLine("${character.skills}")
    appendLine("${character.savingThrows}")
}.let(::println)