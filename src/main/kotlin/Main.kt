package io.vbytsyuk.dnd

import io.vbytsyuk.dnd.core.*
import io.vbytsyuk.dnd.core.race.*

fun main() {
    val artur = Character(
        name = "Artur",
        race = HalfElf(Stat.Dexterity(), Stat.Wisdom()),
        `class` = Rogue,
        statBlock = StatBlock(
            strength = 8, dexterity = 16, constitution = 13,
            intelligence = 10, wisdom = 15, charisma = 14,
        ),
        level = Level(5),
    )
    println("$artur")
}

