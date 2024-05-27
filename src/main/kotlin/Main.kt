package io.vbytsyuk.dnd

import io.vbytsyuk.dnd.core.*
import io.vbytsyuk.dnd.core.`class`.Monk
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.race.*
import io.vbytsyuk.dnd.core.skills.Skill
import io.vbytsyuk.dnd.sheet.Sheet
import io.vbytsyuk.dnd.sheet.print

fun main() {
    val artur = Character(
        name = "Artur",
        race = HalfElf(chosenStat1 = StatType.DEX, chosenStat2 = StatType.WIS),
        `class` = Monk(
            proficientSkills = Skills2(
                Skill.Strength.Athletics,
                Skill.Dexterity.Acrobatics,
            )
        ),
        initialRawStatBlock = StatBlock(
            strength = 8, dexterity = 15, constitution = 13,
            intelligence = 10, wisdom = 14, charisma = 12,
        ),
        level = Level(5),
    )
    val sheet = Sheet(character = artur, playerName = "Artem")
    sheet.print()
}

