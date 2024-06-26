package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType.CON
import io.vbytsyuk.dnd.core.StatType.INT
import io.vbytsyuk.dnd.core.armor.Armor.Type.*
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Dexterity.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*
import io.vbytsyuk.dnd.core.weapon.Weapon.ProficiencyType.SIMPLE

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
        weapons = { it.proficiencyType == SIMPLE },
        armor = {  it.type is Light || it.type is Medium || it.type is Shield },
    )

    companion object {
        val allowedProficientSkills = listOf(
            Arcana, History, Investigation, Medicine, Nature, Perception, SleightOfHand
        )
    }
}
