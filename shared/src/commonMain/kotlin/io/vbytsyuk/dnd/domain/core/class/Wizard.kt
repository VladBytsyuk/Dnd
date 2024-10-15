package io.vbytsyuk.dnd.domain.core.`class`

import io.vbytsyuk.dnd.domain.core.Dice
import io.vbytsyuk.dnd.domain.core.StatType.INT
import io.vbytsyuk.dnd.domain.core.StatType.WIS
import io.vbytsyuk.dnd.domain.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.core.proficiencies.Skills2
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Arcana
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.History
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Investigation
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Religion
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Medicine
import io.vbytsyuk.dnd.domain.core.weapon.Dagger
import io.vbytsyuk.dnd.domain.core.weapon.Dart
import io.vbytsyuk.dnd.domain.core.weapon.LightCrossbow
import io.vbytsyuk.dnd.domain.core.weapon.Quarterstaff
import io.vbytsyuk.dnd.domain.core.weapon.Sling
import io.vbytsyuk.dnd.domain.core.weapon.WeaponChecker

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
