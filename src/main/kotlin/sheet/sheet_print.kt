package io.vbytsyuk.dnd.sheet

import io.vbytsyuk.dnd.core.character.armorClass
import io.vbytsyuk.dnd.core.character.initiative
import io.vbytsyuk.dnd.core.character.savingThrows
import io.vbytsyuk.dnd.core.character.skills
import io.vbytsyuk.dnd.core.units.Language

fun Sheet.print() = buildString {
    val char = character
    appendLine("----------------------------------")
    append("${char.name}, ")
    append("${char.race::class.simpleName}, ${char.level} (${char.exp}), ${char.`class`::class.simpleName}, ")
    append("${char.maxHp}, ")
    append("Proficiency: ${char.proficiencyBonus}, ")
    appendLine("Alignment = ${char.alignment}")
    appendLine("Background = ${char.background}")
    append("AC: ${char.armorClass}, Initiative: ${char.initiative}, Speed: ${char.race.baseSpeed}")
    appendLine(if (char.race.darkVision != null) ", Dark vision: ${char.race.darkVision}" else "")
    appendLine("Languages: ${Language.all.filter { char.proficiencies.languages.check(it) }}")
    appendLine("${char.statBlock}")
    appendLine("${char.skills}")
    appendLine("Saving throws: ${char.savingThrows}")
    appendLine("Equipment: ${char.equipment}")
}.let(::println)