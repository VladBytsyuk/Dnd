package io.vbytsyuk.dnd.sheet.utils

import io.vbytsyuk.dnd.core.sheet.Sheet

fun Sheet.Skills.toStringOutput() = """
    Skills: Proficiency = $proficiencyBonus,
        STR = ${strength.toStringOutput()}
        DEX = ${dexterity.toStringOutput()}
        CON = ${constitution.toStringOutput()}
        INT = ${intelligence.toStringOutput()}
        WIS = ${wisdom.toStringOutput()}
        CHA = ${charisma.toStringOutput()}
""".trimIndent()

private fun Sheet.Skills.Data.toStringOutput() = "$value($modifier),\tsavingThrow = $savingThrow\t\t$skills"
