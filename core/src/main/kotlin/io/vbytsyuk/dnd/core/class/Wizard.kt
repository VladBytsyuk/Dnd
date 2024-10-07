package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType.INT
import io.vbytsyuk.dnd.core.StatType.WIS
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.Arcana
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.History
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.Investigation
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.Religion
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.Medicine
import io.vbytsyuk.dnd.core.weapon.Dagger
import io.vbytsyuk.dnd.core.weapon.Dart
import io.vbytsyuk.dnd.core.weapon.LightCrossbow
import io.vbytsyuk.dnd.core.weapon.Quarterstaff
import io.vbytsyuk.dnd.core.weapon.Sling
import io.vbytsyuk.dnd.core.weapon.WeaponChecker

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
