package io.vbytsyuk.dnd.domain.core.`class`

import io.vbytsyuk.dnd.domain.core.Dice
import io.vbytsyuk.dnd.domain.core.StatType.INT
import io.vbytsyuk.dnd.domain.core.StatType.WIS
import io.vbytsyuk.dnd.domain.core.armor.ArmorChecker
import io.vbytsyuk.dnd.domain.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.core.proficiencies.Skills2
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Arcana
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Nature
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Religion
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.AnimalHandling
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Medicine
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Perception
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Survival
import io.vbytsyuk.dnd.domain.core.weapon.Club
import io.vbytsyuk.dnd.domain.core.weapon.Dagger
import io.vbytsyuk.dnd.domain.core.weapon.Dart
import io.vbytsyuk.dnd.domain.core.weapon.Javelin
import io.vbytsyuk.dnd.domain.core.weapon.Mace
import io.vbytsyuk.dnd.domain.core.weapon.Quarterstaff
import io.vbytsyuk.dnd.domain.core.weapon.Scimitar
import io.vbytsyuk.dnd.domain.core.weapon.Sickle
import io.vbytsyuk.dnd.domain.core.weapon.Sling
import io.vbytsyuk.dnd.domain.core.weapon.Spear
import io.vbytsyuk.dnd.domain.core.weapon.WeaponChecker

class Druid(
    proficientSkills: Skills2,
) : io.vbytsyuk.dnd.domain.core.`class`.Class {

    override val hpDice = Dice.D8
    override val proficiencies = Proficiencies(
        savingThrows = listOf(INT, WIS),
        skills = ProficiencySkills(
            allowed = io.vbytsyuk.dnd.domain.core.`class`.Druid.Companion.allowedProficientSkills,
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
