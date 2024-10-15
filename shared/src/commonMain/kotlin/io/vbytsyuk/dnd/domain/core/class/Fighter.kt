package io.vbytsyuk.dnd.domain.core.`class`

import io.vbytsyuk.dnd.domain.core.Dice
import io.vbytsyuk.dnd.domain.core.StatType.CON
import io.vbytsyuk.dnd.domain.core.StatType.STR
import io.vbytsyuk.dnd.domain.core.armor.ArmorChecker
import io.vbytsyuk.dnd.domain.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.core.proficiencies.Skills2
import io.vbytsyuk.dnd.domain.core.skills.Skill.Charisma.Intimidation
import io.vbytsyuk.dnd.domain.core.skills.Skill.Dexterity.Acrobatics
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.History
import io.vbytsyuk.dnd.domain.core.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.AnimalHandling
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Perception
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Survival
import io.vbytsyuk.dnd.domain.core.weapon.WeaponChecker

class Fighter(
    proficientSkills: Skills2,
) : Class {

    override val hpDice = Dice.D10
    override val proficiencies = Proficiencies(
        savingThrows = listOf(STR, CON),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = WeaponChecker.Full(),
        armor = ArmorChecker.Full(),
    )

    companion object {
        val allowedProficientSkills = listOf(
            Athletics, Acrobatics, Perception, Survival, Intimidation, History, Insight, AnimalHandling,
        )
    }
}
