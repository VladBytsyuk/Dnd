package io.vbytsyuk.dnd.domain.core.`class`

import io.vbytsyuk.dnd.domain.core.Dice
import io.vbytsyuk.dnd.domain.core.StatType.CHA
import io.vbytsyuk.dnd.domain.core.StatType.CON
import io.vbytsyuk.dnd.domain.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.core.proficiencies.Skills2
import io.vbytsyuk.dnd.domain.core.skills.Skill.Charisma.Deception
import io.vbytsyuk.dnd.domain.core.skills.Skill.Charisma.Intimidation
import io.vbytsyuk.dnd.domain.core.skills.Skill.Charisma.Persuasion
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Arcana
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Religion
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.domain.core.weapon.Dagger
import io.vbytsyuk.dnd.domain.core.weapon.Dart
import io.vbytsyuk.dnd.domain.core.weapon.LightCrossbow
import io.vbytsyuk.dnd.domain.core.weapon.Quarterstaff
import io.vbytsyuk.dnd.domain.core.weapon.Sling
import io.vbytsyuk.dnd.domain.core.weapon.WeaponChecker

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
