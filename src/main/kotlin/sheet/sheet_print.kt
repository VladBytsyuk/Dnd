package io.vbytsyuk.dnd.sheet

import io.vbytsyuk.dnd.core.character.armorClass
import io.vbytsyuk.dnd.core.character.initiative
import io.vbytsyuk.dnd.core.character.savingThrows
import io.vbytsyuk.dnd.core.character.skills
import io.vbytsyuk.dnd.core.units.Language

fun Sheet.print() = buildString {
    appendLine("----------------------------------")
    append("${base.name}, ")
    append("${base.race}, ${base.level} (${base.exp}), ${base.`class`}, ")
    append("${health.maxHp}, ")
    append("Proficiency: ${skills.proficiencyBonus}, ")
    appendLine("Alignment = ${base.alignment}")
    appendLine("Background = ${base.background}")
    append("AC: ${health.armorClass}, Initiative: ${passive.initiative}, Speed: ${passive.speed}, Size: ${passive.size}")
    appendLine(if (passive.darkVision != null) ", Dark vision = ${passive.darkVision}" else "")
//    appendLine("Languages: ${Language.all.filter { char.proficiencies.languages.check(it) }}")
    appendLine("${skills}")
    appendLine("Equipment: ${equipment}")
}.let(::println)