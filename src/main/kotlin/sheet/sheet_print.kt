package io.vbytsyuk.dnd.sheet

import io.vbytsyuk.dnd.core.character.armorClass
import io.vbytsyuk.dnd.core.character.initiative
import io.vbytsyuk.dnd.core.character.savingThrows
import io.vbytsyuk.dnd.core.character.skills

fun Sheet.print() = buildString {
    val char = character
    appendLine("----------------------------------")
    append("${char.name}, ")
    append("${char.race::class.simpleName}, ${char.level}, ${char.`class`::class.simpleName}, ")
    append("${char.hpBlock}, ")
    appendLine("Proficiency: ${char.proficiencyBonus}")
    append("AC: ${char.armorClass}, Initiative: ${char.initiative}, Speed: ${char.race.baseSpeed}")
    appendLine(if (char.race.darkVision != null) ", Dark vision: ${char.race.darkVision}" else "")
    appendLine("${char.statBlock}")
    appendLine("${char.skills}")
    appendLine("Saving throws: ${char.savingThrows}")
    appendLine("Equipment: ${char.equipment}")
}.let(::println)