package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills1
import io.vbytsyuk.dnd.core.skills.Skill
import io.vbytsyuk.dnd.core.units.Distance
import io.vbytsyuk.dnd.core.units.feet
import io.vbytsyuk.dnd.core.units.Size
import io.vbytsyuk.dnd.core.util.Checker
import io.vbytsyuk.dnd.core.weapon.*

sealed class Elf(
    bonusStatBlock: StatBlock,
    baseSpeed: Speed? = null,
    darkVision: Distance? = null,
    weaponProficiency: Checker<Weapon>,
) : Race(
    bonusStatBlock = bonusStatBlock,
    size = Size.MEDIUM,
    baseSpeed = baseSpeed ?: Speed(30.feet),
    darkVision = darkVision ?: 60.feet,
    proficiencies = Proficiencies(
        skills = ProficiencySkills(selected = Skills1(skill = Skill.Wisdom.Perception)),
        weapons = weaponProficiency,
    )
) {
    data object High : Elf(
        bonusStatBlock = StatBlock(dexterity = 2, intelligence = 1),
        weaponProficiency = Checker { it in setOf(Longsword, Shortsword, Longbow, Shortbow) },
    )

    data object Wood : Elf(
        bonusStatBlock = StatBlock(dexterity = 2, wisdom = 1),
        baseSpeed = Speed(35.feet),
        weaponProficiency = Checker { it in setOf(Longsword, Shortsword, Longbow, Shortbow) },
    )

    data object Drow : Elf(
        bonusStatBlock = StatBlock(dexterity = 2, charisma = 1),
        darkVision = 120.feet,
        weaponProficiency = Checker { it in setOf(Rapier, Shortsword, HandCrossbow) },
    )
}
