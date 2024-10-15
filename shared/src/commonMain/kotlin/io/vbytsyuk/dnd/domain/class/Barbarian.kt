package io.vbytsyuk.dnd.domain.`class`

import io.vbytsyuk.dnd.domain.Dice
import io.vbytsyuk.dnd.domain.StatType.CON
import io.vbytsyuk.dnd.domain.StatType.STR
import io.vbytsyuk.dnd.domain.armor.ArmorChecker
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.proficiencies.Skills2
import io.vbytsyuk.dnd.domain.skills.Skill.Charisma.Intimidation
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Nature
import io.vbytsyuk.dnd.domain.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.AnimalHandling
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Perception
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Survival
import io.vbytsyuk.dnd.domain.weapon.WeaponChecker

class Barbarian(
    proficientSkills: Skills2,
) : Class {

    override val hpDice = Dice.D12
    override val proficiencies = Proficiencies(
        savingThrows = listOf(STR, CON),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = WeaponChecker.Full(),
        armor = ArmorChecker(light = true, medium = true, shield = true),
    )

    companion object{
        val allowedProficientSkills = listOf(
            Athletics, Perception, Survival, Intimidation, Nature, AnimalHandling,
        )
    }
}
