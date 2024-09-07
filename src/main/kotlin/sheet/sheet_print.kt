package io.vbytsyuk.dnd.sheet

fun Sheet.print() = buildString {
    appendLine("----------------------------------")
    append("${base.name}, ")
    append("${base.race}, ${base.level} (${base.exp} xp), ${base.`class`}, ")
    append("${health.maxHp}, ")
    append("Proficiency: ${skills.proficiencyBonus}, ")
    appendLine("Alignment = ${base.alignment}")
    appendLine("Background = ${base.background}")
    append("AC: ${health.armorClass}, Initiative: ${passive.initiative}, Speed: ${passive.speed}, Size: ${passive.size}")
    appendLine(if (passive.darkVision != null) ", Dark vision = ${passive.darkVision}" else "")
//    appendLine("Languages: ${Language.all.filter { it.toString() in proficiencies.languages }}")
    appendLine("${proficiencies}")
    appendLine("${skills}")

    appendLine("Equipment: ${equipment}")
}.let(::println)