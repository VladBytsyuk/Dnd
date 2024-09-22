package io.vbytsyuk.dnd

import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.armor.PlateArmor
import io.vbytsyuk.dnd.core.background.Entertainer
import io.vbytsyuk.dnd.core.character.Character
import io.vbytsyuk.dnd.core.`class`.Bard
import io.vbytsyuk.dnd.core.equipment.Equipment
import io.vbytsyuk.dnd.core.equipment.equipped
import io.vbytsyuk.dnd.core.equipment.unequipped
import io.vbytsyuk.dnd.core.language.Language
import io.vbytsyuk.dnd.core.proficiencies.Skills3
import io.vbytsyuk.dnd.core.race.Human
import io.vbytsyuk.dnd.core.skills.Skill
import io.vbytsyuk.dnd.core.tools.Flute
import io.vbytsyuk.dnd.core.units.*
import io.vbytsyuk.dnd.core.units.GoodVsEvil.GOOD
import io.vbytsyuk.dnd.core.units.LawVsChaos.LAWFUL
import io.vbytsyuk.dnd.core.weapon.Dagger
import io.vbytsyuk.dnd.core.weapon.Dart
import io.vbytsyuk.dnd.core.weapon.Longbow
import io.vbytsyuk.dnd.core.weapon.Rapier
import io.vbytsyuk.dnd.sheet.Sheet
import io.vbytsyuk.dnd.sheet.print

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
    sheet.print()
}

