package io.vbytsyuk.dnd.core.proficiencies

import io.vbytsyuk.dnd.core.util.Checker
import io.vbytsyuk.dnd.core.units.Level
import io.vbytsyuk.dnd.core.Modifier
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.armor.Armor
import io.vbytsyuk.dnd.core.skills.Skill
import io.vbytsyuk.dnd.core.weapon.Weapon
import kotlin.math.ceil

data class Proficiencies(
    val savingThrows: List<StatType> = emptyList(),
    val skills: ProficiencySkills = ProficiencySkills(),
    val weapons: Checker<Weapon> = Checker { false },
    val armor: Checker<Armor> = Checker { false },
)

data class ProficiencySkills(
    val allowed: List<Skill> = Skill.skills(),
    val selected: Skills = Skills0,
)

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
