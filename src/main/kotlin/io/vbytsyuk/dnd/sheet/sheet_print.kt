package io.vbytsyuk.dnd.sheet

import io.vbytsyuk.dnd.sheet.utils.toStringOutput

fun Sheet.print() = buildString {
    appendLine("----------------------------------")
    append("${base.name}, ")
    append("${base.race}, ${base.level} lvl (${base.exp} xp), ${base.`class`}, ")
    append("${health.toStringOutput()}, ")
    appendLine("Alignment = ${base.alignment}")
    appendLine(deathSavingThrows.toStringOutput())
    appendLine("Background = ${base.background}")
    append("AC: ${health.armorClass}, Initiative: ${passive.initiative}, ")
    append("Speed: ${passive.speed} ft, Size: ${passive.size}")
    appendLine(if (passive.darkVision != null) ", Dark vision = ${passive.darkVision}" else "")
    appendLine(proficiencies.toStringOutput())
    appendLine(skills.toStringOutput())
    appendLine(equipment.toStringOutput())
    appendLine("Money: ${wallet.toStringOutput()}")
    appendLine(weaponsAttacks.toStringOutput())
    appendLine(personality.toStringOutput())
}.let(::println)
