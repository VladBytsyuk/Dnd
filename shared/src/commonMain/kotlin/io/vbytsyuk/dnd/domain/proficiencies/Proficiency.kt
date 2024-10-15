package io.vbytsyuk.dnd.domain.proficiencies

import io.vbytsyuk.dnd.domain.Modifier
import io.vbytsyuk.dnd.domain.StatType
import io.vbytsyuk.dnd.domain.armor.ArmorChecker
import io.vbytsyuk.dnd.domain.language.LanguageChecker
import io.vbytsyuk.dnd.domain.skills.Skill
import io.vbytsyuk.dnd.domain.tools.ToolsChecker
import io.vbytsyuk.dnd.domain.units.Level
import io.vbytsyuk.dnd.domain.weapon.WeaponChecker
import kotlin.math.ceil

class Proficiencies(
    val savingThrows: List<StatType> = emptyList(),
    val skills: List<Skill>,
    val weapons: WeaponChecker = WeaponChecker(),
    val armor: ArmorChecker = ArmorChecker(),
    val tools: ToolsChecker = ToolsChecker(),
    val languages: LanguageChecker = LanguageChecker(),
) {
    constructor(
        savingThrows: List<StatType> = emptyList(),
        skills: ProficiencySkills = ProficiencySkills(),
        weapons: WeaponChecker = WeaponChecker(),
        armor: ArmorChecker = ArmorChecker(),
        tools: ToolsChecker = ToolsChecker(),
        languages: LanguageChecker = LanguageChecker(),
    ) : this(
        savingThrows = savingThrows,
        skills = skills.selected.list,
        weapons = weapons,
        armor = armor,
        tools = tools,
        languages = languages,
    )

    operator fun plus(other: Proficiencies) = Proficiencies(
        savingThrows = (this.savingThrows + other.savingThrows).distinct(),
        skills = (this.skills + other.skills).distinct(),
        weapons = this.weapons + other.weapons,
        armor = this.armor + other.armor,
        tools = this.tools + other.tools,
        languages = this.languages + other.languages,
    )
}

data class ProficiencySkills(
    val allowed: List<Skill> = Skill.all(),
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

@Suppress("MagicNumber")
fun calculateProficiencyBonus(level: Level): Modifier =
    Modifier(ceil(level.value / 4.0).toInt() + 1)

@Suppress("MagicNumber")
fun calculateCanonicalProficiencyBonus(level: Level): Modifier = when (level.value) {
    in 1 .. 4 -> Modifier(2)
    in 5..8 -> Modifier(3)
    in 9..12 -> Modifier(4)
    in 13..16 -> Modifier(5)
    in 17..20 -> Modifier(6)
    else -> error("level should be in 1..20")
}
