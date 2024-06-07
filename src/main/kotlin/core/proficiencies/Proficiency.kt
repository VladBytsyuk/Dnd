package io.vbytsyuk.dnd.core.proficiencies

import io.vbytsyuk.dnd.core.util.Checker
import io.vbytsyuk.dnd.core.units.Level
import io.vbytsyuk.dnd.core.Modifier
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.armor.Armor
import io.vbytsyuk.dnd.core.skills.Skill
import io.vbytsyuk.dnd.core.units.Language
import io.vbytsyuk.dnd.core.weapon.Weapon
import kotlin.math.ceil

class Proficiencies(
    val savingThrows: List<StatType> = emptyList(),
    val skills: List<Skill>,
    val weapons: Checker<Weapon> = Checker { false },
    val armor: Checker<Armor> = Checker { false },
    val languages: Checker<Language> = Checker { false }
) {
    constructor(
        savingThrows: List<StatType> = emptyList(),
        skills: ProficiencySkills = ProficiencySkills(),
        weapons: Checker<Weapon> = Checker { false },
        armor: Checker<Armor> = Checker { false },
        languages: Checker<Language> = Checker { false }
    ) : this(
        savingThrows = savingThrows,
        skills = skills.selected.list,
        weapons = weapons,
        armor = armor,
        languages = languages,
    )

    operator fun plus(other: Proficiencies) = Proficiencies(
        savingThrows = (this.savingThrows + other.savingThrows).distinct(),
        skills = (this.skills + other.skills).distinct(),
        weapons = this.weapons + other.weapons,
        armor = this.armor + other.armor,
        languages = this.languages + other.languages,
    )
}

data class ProficiencySkills(
    val allowed: List<Skill> = Skill.skills(),
    val selected: Skills = Skills0,
) {

    init { requireSelectOnlyAllowedSkills() }

    private fun requireSelectOnlyAllowedSkills() = require(selected.list.all { it in allowed }) {
        """
            Incorrect proficient skills.
            Selected ${selected.list},
            but should be ${selected.list.size} of $allowed.
        """.trimIndent()
    }
}

fun calculateProficiencyBonus(level: Level): Modifier =
    Modifier(ceil(level.value / 4.0).toInt() + 1)

fun calculateCanonicalProficiencyBonus(level: Level): Modifier = when (level.value) {
    in 1 .. 4 -> Modifier(2)
    in 5..8 -> Modifier(3)
    in 9..12 -> Modifier(4)
    in 13..16 -> Modifier(5)
    in 17..20 -> Modifier(6)
    else -> throw IllegalStateException("level should be in 1..20")
}
