package io.vbytsyuk.dnd

import io.vbytsyuk.dnd.core.*
import io.vbytsyuk.dnd.core.race.*
import io.vbytsyuk.dnd.sheet.Sheet
import io.vbytsyuk.dnd.sheet.print

fun main() {
    val artur = Character(
        name = "Artur",
        race = HalfElf(chosenStat1 = StatType.DEX, chosenStat2 = StatType.WIS),
        `class` = Monk,
        initialRawStatBlock = StatBlock(
            strength = 8, dexterity = 15, constitution = 13,
            intelligence = 10, wisdom = 14, charisma = 12,
        ),
        level = Level(5),
    )
    val sheet = Sheet(character = artur, playerName = "Artem")
    sheet.print()
}

