package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType.CON
import io.vbytsyuk.dnd.core.StatType.INT
import io.vbytsyuk.dnd.core.armor.Armor.Type.*
import io.vbytsyuk.dnd.core.armor.ArmorChecker
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Dexterity.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*
import io.vbytsyuk.dnd.core.weapon.Weapon.ProficiencyType.SIMPLE
import io.vbytsyuk.dnd.core.weapon.WeaponChecker

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
