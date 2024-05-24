package io.vbytsyuk.dnd

import io.vbytsyuk.dnd.core.*
import io.vbytsyuk.dnd.core.race.*
import io.vbytsyuk.dnd.sheet.Sheet
import io.vbytsyuk.dnd.sheet.print

fun main() {
    val artur = Character(
        name = "Artur",
        race = Tiefling.Fierna,
        `class` = Rogue,
        statBlock = StatBlock(
            strength = 8, dexterity = 16, constitution = 13,
            intelligence = 10, wisdom = 15, charisma = 14,
        ),
        level = Level(5),
    )
    val sheet = Sheet(character = artur, playerName = "Artem")
    sheet.print()
}

