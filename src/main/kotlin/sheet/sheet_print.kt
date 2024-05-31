package io.vbytsyuk.dnd.sheet

fun Sheet.print() = buildString {
    val char = character
    appendLine("----------------------------------")
    append("${char.name}, ")
    append("${char.race::class.simpleName} ${char.level} ${char.`class`::class.simpleName} ")
    appendLine("${char.hp}${if (char.temporaryHp.value > 0) char.temporaryHp else ""}/${char.maxHp}")
    appendLine("${char.statBlock}")
    appendLine("${char.skills}")
    appendLine("Saving throws: ${char.savingThrows}")
    appendLine("Equipment: ${char.equipment}")
    appendLine("AC: ${char.armorClass}")
}.let(::println)