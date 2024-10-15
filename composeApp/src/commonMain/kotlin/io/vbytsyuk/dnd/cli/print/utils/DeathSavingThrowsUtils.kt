package io.vbytsyuk.dnd.cli.print.utils

import io.vbytsyuk.dnd.domain.core.sheet.Sheet

fun Sheet.DeathSavingThrows.toStringOutput(): String = buildString {
    append("Death saving throws: [")
    for (i in 1..Sheet.DeathSavingThrows.MAX_COUNT) { append(if (i <= successes) "✓" else "_") }
    append("|")
    for (i in 1..Sheet.DeathSavingThrows.MAX_COUNT) { append(if (i <= failures) "✗" else "_") }
    append("]")
}
