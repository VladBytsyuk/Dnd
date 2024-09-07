package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType.CON
import io.vbytsyuk.dnd.core.StatType.STR
import io.vbytsyuk.dnd.core.armor.ArmorChecker
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Charisma.*
import io.vbytsyuk.dnd.core.skills.Skill.Dexterity.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*
import io.vbytsyuk.dnd.core.weapon.WeaponChecker

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
