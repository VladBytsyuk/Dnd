package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType.INT
import io.vbytsyuk.dnd.core.StatType.WIS
import io.vbytsyuk.dnd.core.armor.ArmorChecker
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.Arcana
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.Nature
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.Religion
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.AnimalHandling
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.Medicine
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.Perception
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.Survival
import io.vbytsyuk.dnd.core.weapon.Club
import io.vbytsyuk.dnd.core.weapon.Dagger
import io.vbytsyuk.dnd.core.weapon.Dart
import io.vbytsyuk.dnd.core.weapon.Javelin
import io.vbytsyuk.dnd.core.weapon.Mace
import io.vbytsyuk.dnd.core.weapon.Quarterstaff
import io.vbytsyuk.dnd.core.weapon.Scimitar
import io.vbytsyuk.dnd.core.weapon.Sickle
import io.vbytsyuk.dnd.core.weapon.Sling
import io.vbytsyuk.dnd.core.weapon.Spear
import io.vbytsyuk.dnd.core.weapon.WeaponChecker

class Druid(
    proficientSkills: Skills2,
) : Class {

    override val hpDice = Dice.D8
    override val proficiencies = Proficiencies(
        savingThrows = listOf(INT, WIS),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = WeaponChecker(
            specific = setOf(Quarterstaff, Mace, Dart, Club, Dagger, Spear, Javelin, Sling, Sickle, Scimitar),
        ),
        armor = ArmorChecker(light = true, medium = true, shield = true),
    )

    companion object {
        val allowedProficientSkills = listOf(
            Perception, Survival, Arcana, Medicine, AnimalHandling, Nature, Insight, Religion,
        )
    }
}
