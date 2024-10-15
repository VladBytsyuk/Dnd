package io.vbytsyuk.dnd.domain.`class`

import io.vbytsyuk.dnd.domain.Dice
import io.vbytsyuk.dnd.domain.StatType.CHA
import io.vbytsyuk.dnd.domain.StatType.CON
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.proficiencies.Skills2
import io.vbytsyuk.dnd.domain.skills.Skill.Charisma.Deception
import io.vbytsyuk.dnd.domain.skills.Skill.Charisma.Intimidation
import io.vbytsyuk.dnd.domain.skills.Skill.Charisma.Persuasion
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Arcana
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Religion
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.domain.weapon.Dagger
import io.vbytsyuk.dnd.domain.weapon.Dart
import io.vbytsyuk.dnd.domain.weapon.LightCrossbow
import io.vbytsyuk.dnd.domain.weapon.Quarterstaff
import io.vbytsyuk.dnd.domain.weapon.Sling
import io.vbytsyuk.dnd.domain.weapon.WeaponChecker

class Sorcerer(
    proficientSkills: Skills2,
) : Class {

    override val hpDice = Dice.D6
    override val proficiencies = Proficiencies(
        savingThrows = listOf(CON, CHA),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = WeaponChecker(specific = setOf(Quarterstaff, Dart, Dagger, LightCrossbow, Sling)),
    )

    companion object {
        val allowedProficientSkills = listOf(
            Intimidation, Arcana, Deception, Insight, Religion, Persuasion,
        )
    }
}
