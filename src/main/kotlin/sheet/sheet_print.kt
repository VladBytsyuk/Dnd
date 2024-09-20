package io.vbytsyuk.dnd.sheet

fun Sheet.print() = buildString {
    appendLine("----------------------------------")
    append("${base.name}, ")
    append("${base.race}, ${base.level} lvl (${base.exp} xp), ${base.`class`}, ")
    append("${health.toHealthString()}, ")
    appendLine("Alignment = ${base.alignment}")
    appendLine("Background = ${base.background}")
    append("AC: ${health.armorClass}, Initiative: ${passive.initiative}, Speed: ${passive.speed} ft, Size: ${passive.size}")
    appendLine(if (passive.darkVision != null) ", Dark vision = ${passive.darkVision}" else "")
    appendLine(proficiencies.toProficienciesString())
    appendLine(skills.toSkillsString())
    appendLine("Equipment: $equipment")
    appendLine("Money: ${wallet.toStringOutput()}")
}.let(::println)