package io.vbytsyuk.dnd.domain.`class`

import io.vbytsyuk.dnd.domain.Dice
import io.vbytsyuk.dnd.domain.StatType.DEX
import io.vbytsyuk.dnd.domain.StatType.STR
import io.vbytsyuk.dnd.domain.armor.ArmorChecker
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.proficiencies.Skills3
import io.vbytsyuk.dnd.domain.skills.Skill.Dexterity.Stealth
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Investigation
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Nature
import io.vbytsyuk.dnd.domain.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.AnimalHandling
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Perception
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Survival
import io.vbytsyuk.dnd.domain.weapon.WeaponChecker

class Ranger(
    proficientSkills: Skills3,
) : Class {

    override val hpDice = Dice.D10
    override val proficiencies = Proficiencies(
        savingThrows = listOf(STR, DEX),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = WeaponChecker.Full(),
        armor = ArmorChecker(light = true, medium = true, shield = true),
    )

    companion object {
        val allowedProficientSkills = listOf(
            Investigation, Athletics, Perception, Survival, Nature, Insight, Stealth, AnimalHandling,
        )
    }
}
