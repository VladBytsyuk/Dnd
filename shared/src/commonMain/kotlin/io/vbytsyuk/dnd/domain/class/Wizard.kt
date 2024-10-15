package io.vbytsyuk.dnd.domain.`class`

import io.vbytsyuk.dnd.domain.Dice
import io.vbytsyuk.dnd.domain.StatType.INT
import io.vbytsyuk.dnd.domain.StatType.WIS
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.proficiencies.Skills2
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Arcana
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.History
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Investigation
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Religion
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Medicine
import io.vbytsyuk.dnd.domain.weapon.Dagger
import io.vbytsyuk.dnd.domain.weapon.Dart
import io.vbytsyuk.dnd.domain.weapon.LightCrossbow
import io.vbytsyuk.dnd.domain.weapon.Quarterstaff
import io.vbytsyuk.dnd.domain.weapon.Sling
import io.vbytsyuk.dnd.domain.weapon.WeaponChecker

class Wizard(
    proficientSkills: Skills2,
) : Class {

    override val hpDice = Dice.D6
    override val proficiencies = Proficiencies(
        savingThrows = listOf(INT, WIS),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = WeaponChecker(specific = setOf(Dagger, Dart, Sling, Quarterstaff, LightCrossbow)),
    )

    companion object {
        val allowedProficientSkills = listOf(
            Investigation, History, Arcana, Medicine, Insight, Religion,
        )
    }
}
