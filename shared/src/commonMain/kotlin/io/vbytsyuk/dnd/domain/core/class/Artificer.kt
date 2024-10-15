package io.vbytsyuk.dnd.domain.core.`class`

import io.vbytsyuk.dnd.domain.core.Dice
import io.vbytsyuk.dnd.domain.core.StatType.CON
import io.vbytsyuk.dnd.domain.core.StatType.INT
import io.vbytsyuk.dnd.domain.core.armor.ArmorChecker
import io.vbytsyuk.dnd.domain.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.core.proficiencies.Skills2
import io.vbytsyuk.dnd.domain.core.skills.Skill.Dexterity.SleightOfHand
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Arcana
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.History
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Investigation
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Nature
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Medicine
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Perception
import io.vbytsyuk.dnd.domain.core.weapon.WeaponChecker

class Artificer(
    proficientSkills: Skills2,
) : Class {

    override val hpDice = Dice.D8
    override val proficiencies = Proficiencies(
        savingThrows = listOf(CON, INT),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = WeaponChecker(simple = true),
        armor = ArmorChecker(light = true, medium = true, shield = true),
    )

    companion object {
        val allowedProficientSkills = listOf(
            Arcana, History, Investigation, Medicine, Nature, Perception, SleightOfHand
        )
    }
}
