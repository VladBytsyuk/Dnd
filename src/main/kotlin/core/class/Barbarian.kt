package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType.CON
import io.vbytsyuk.dnd.core.StatType.STR
import io.vbytsyuk.dnd.core.armor.Armor.Type.*
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Charisma.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*

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
        weapons = { true },
        armor = {  it.type is Light || it.type is Medium || it.type is Shield },
    )

    companion object{
        val allowedProficientSkills = listOf(
            Athletics, Perception, Survival, Intimidation, Nature, AnimalHandling,
        )
    }
}
