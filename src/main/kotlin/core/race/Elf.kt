package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills1
import io.vbytsyuk.dnd.core.skills.Skill
import io.vbytsyuk.dnd.core.units.*
import io.vbytsyuk.dnd.core.units.Language.Common
import io.vbytsyuk.dnd.core.units.Language.Elvish
import io.vbytsyuk.dnd.core.util.Checker
import io.vbytsyuk.dnd.core.weapon.*

sealed class Elf(
    override val bonusStatBlock: StatBlock,
    baseSpeed: Speed? = null,
    darkVision: Distance? = null,
    weaponProficiency: WeaponChecker,
) : Race {

    override val size = Size.MEDIUM
    override val baseSpeed = baseSpeed ?: Speed(30.feet)
    override val darkVision = darkVision ?: 60.feet
    override val proficiencies = Proficiencies(
        skills = ProficiencySkills(selected = Skills1(skill = Skill.Wisdom.Perception)),
        weapons = weaponProficiency,
        languages = { it in listOf(Common, Elvish) },
    )

    data object High : Elf(
        bonusStatBlock = StatBlock(dexterity = 2, intelligence = 1),
        weaponProficiency = WeaponChecker(specific = setOf(Longsword, Shortsword, Longbow, Shortbow)),
    )

    data object Wood : Elf(
        bonusStatBlock = StatBlock(dexterity = 2, wisdom = 1),
        baseSpeed = Speed(35.feet),
        weaponProficiency = WeaponChecker(specific = setOf(Longsword, Shortsword, Longbow, Shortbow)),
    )

    data object Drow : Elf(
        bonusStatBlock = StatBlock(dexterity = 2, charisma = 1),
        darkVision = 120.feet,
        weaponProficiency = WeaponChecker(specific = setOf(Rapier, Shortsword, HandCrossbow)),
    )
}
