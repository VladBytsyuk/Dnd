package io.vbytsyuk.dnd.cli.print

import io.vbytsyuk.dnd.cli.print.utils.toStringOutput
import io.vbytsyuk.dnd.core.sheet.Sheet

class StringPrinter {
    
    fun print(sheet: Sheet): String = buildString {
        appendLine()
        append("${sheet.base.name}, ")
        append("${sheet.base.race}, ${sheet.base.level} lvl (${sheet.base.exp} xp), ${sheet.base.`class`}, ")
        append("${sheet.health.toStringOutput()}, ")
        appendLine("Alignment = ${sheet.base.alignment}")
        appendLine(sheet.deathSavingThrows.toStringOutput())
        appendLine("Background = ${sheet.base.background}")
        append("AC: ${sheet.health.armorClass}, Initiative: ${sheet.passive.initiative}, ")
        append("Speed: ${sheet.passive.speed} ft, Size: ${sheet.passive.size}")
        appendLine(if (sheet.passive.darkVision != null) ", Dark vision = ${sheet.passive.darkVision}" else "")
        appendLine(sheet.proficiencies.toStringOutput())
        appendLine(sheet.skills.toStringOutput())
        appendLine(sheet.equipment.toStringOutput())
        appendLine("Money: ${sheet.wallet.toStringOutput()}")
        appendLine(sheet.weaponsAttacks.toStringOutput())
        appendLine(sheet.personality.toStringOutput())
    }
}
