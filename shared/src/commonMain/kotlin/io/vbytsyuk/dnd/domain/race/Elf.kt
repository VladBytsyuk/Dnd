package io.vbytsyuk.dnd.domain.race

import io.vbytsyuk.dnd.domain.StatBlock
import io.vbytsyuk.dnd.domain.language.Language.Common
import io.vbytsyuk.dnd.domain.language.Language.Elvish
import io.vbytsyuk.dnd.domain.language.LanguageChecker
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.proficiencies.Skills1
import io.vbytsyuk.dnd.domain.skills.Skill
import io.vbytsyuk.dnd.domain.units.Distance
import io.vbytsyuk.dnd.domain.units.Size
import io.vbytsyuk.dnd.domain.units.Speed
import io.vbytsyuk.dnd.domain.units.feet
import io.vbytsyuk.dnd.domain.weapon.HandCrossbow
import io.vbytsyuk.dnd.domain.weapon.Longbow
import io.vbytsyuk.dnd.domain.weapon.Longsword
import io.vbytsyuk.dnd.domain.weapon.Rapier
import io.vbytsyuk.dnd.domain.weapon.Shortbow
import io.vbytsyuk.dnd.domain.weapon.Shortsword
import io.vbytsyuk.dnd.domain.weapon.WeaponChecker

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
        languages = LanguageChecker(specific = setOf(Common, Elvish))
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
