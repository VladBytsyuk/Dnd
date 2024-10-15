package io.vbytsyuk.dnd.domain.`class`

import io.vbytsyuk.dnd.domain.Dice
import io.vbytsyuk.dnd.domain.StatType.INT
import io.vbytsyuk.dnd.domain.StatType.WIS
import io.vbytsyuk.dnd.domain.armor.ArmorChecker
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.proficiencies.Skills2
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Arcana
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Nature
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Religion
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.AnimalHandling
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Medicine
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Perception
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Survival
import io.vbytsyuk.dnd.domain.weapon.Club
import io.vbytsyuk.dnd.domain.weapon.Dagger
import io.vbytsyuk.dnd.domain.weapon.Dart
import io.vbytsyuk.dnd.domain.weapon.Javelin
import io.vbytsyuk.dnd.domain.weapon.Mace
import io.vbytsyuk.dnd.domain.weapon.Quarterstaff
import io.vbytsyuk.dnd.domain.weapon.Scimitar
import io.vbytsyuk.dnd.domain.weapon.Sickle
import io.vbytsyuk.dnd.domain.weapon.Sling
import io.vbytsyuk.dnd.domain.weapon.Spear
import io.vbytsyuk.dnd.domain.weapon.WeaponChecker

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
