package io.vbytsyuk.dnd.sheet

fun Sheet.print() = buildString {
    val char = character
    appendLine("----------------------------------")
    append("${char.name}, ")
    append("${char.race::class.simpleName}, ${char.level}, ${char.`class`::class.simpleName}, ")
    append("${char.hp}${if (char.temporaryHp.value > 0) char.temporaryHp else ""}/${char.maxHp}, ")
    appendLine("Proficiency: ${char.proficiencyBonus}")
    append("AC: ${char.armorClass}, Initiative: ${char.initiative}, Speed: ${char.race.baseSpeed}")
    appendLine(if (char.race.darkVision != null) ", Dark vision: ${char.race.darkVision}" else "")
    appendLine("${char.statBlock}")
    appendLine("${char.skills}")
    appendLine("Saving throws: ${char.savingThrows}")
    appendLine("Equipment: ${char.equipment}")
}.let(::println)