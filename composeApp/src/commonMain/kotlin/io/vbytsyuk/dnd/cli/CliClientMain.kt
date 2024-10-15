package io.vbytsyuk.dnd.cli

import io.vbytsyuk.dnd.cli.print.StringPrinter
import io.vbytsyuk.dnd.domain.StatBlock
import io.vbytsyuk.dnd.domain.armor.LeatherArmor
import io.vbytsyuk.dnd.domain.armor.PlateArmor
import io.vbytsyuk.dnd.domain.background.Entertainer
import io.vbytsyuk.dnd.domain.character.Character
import io.vbytsyuk.dnd.domain.`class`.Bard
import io.vbytsyuk.dnd.domain.equipment.Equipment
import io.vbytsyuk.dnd.domain.equipment.equipped
import io.vbytsyuk.dnd.domain.equipment.unequipped
import io.vbytsyuk.dnd.domain.language.Language
import io.vbytsyuk.dnd.domain.proficiencies.Skills3
import io.vbytsyuk.dnd.domain.race.Human
import io.vbytsyuk.dnd.domain.sheet.Sheet
import io.vbytsyuk.dnd.domain.skills.Skill
import io.vbytsyuk.dnd.domain.tools.Flute
import io.vbytsyuk.dnd.domain.units.GoodVsEvil.GOOD
import io.vbytsyuk.dnd.domain.units.LawVsChaos.LAWFUL
import io.vbytsyuk.dnd.domain.units.exp
import io.vbytsyuk.dnd.domain.units.plus
import io.vbytsyuk.dnd.domain.weapon.Dagger
import io.vbytsyuk.dnd.domain.weapon.Dart
import io.vbytsyuk.dnd.domain.weapon.Rapier

fun main() {
    val background = Entertainer(
        musicalInstrument = Flute,
        routine = Entertainer.Routine.INSTRUMENTALIST,
    )
    val alice = Character(
        name = "Alice",
        race = Human(chosenLanguage = Language.Dwarvish),
        `class` = Bard(
            proficientSkills = Skills3(
                Skill.Charisma.Intimidation,
                Skill.Charisma.Performance,
                Skill.Intelligence.History,
            ),
        ),
        background = background,
        alignment = LAWFUL + GOOD,
        initialRawStatBlock = StatBlock(
            strength = 8, dexterity = 14, constitution = 13,
            intelligence = 12, wisdom = 10, charisma = 15,
        ),
        exp = 0.exp,
        equipment = Equipment(
            Rapier.equipped(),
            Dart.equipped(count = 20),
            Dagger.unequipped(),
            LeatherArmor.equipped(),
            PlateArmor.unequipped(),
        ),
        personality = Character.Personality(
            trait = background.suggestedCharacteristics.personalityTraits.random().value,
            ideal = background.suggestedCharacteristics.ideals.random().value,
            bond = background.suggestedCharacteristics.bonds.random().value,
            flaw = background.suggestedCharacteristics.flaws.random().value,
        )
    )
    val sheet = Sheet(character = alice)
    val output = StringPrinter().print(sheet)
    println(output)
}
