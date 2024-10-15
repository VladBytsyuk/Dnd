package io.vbytsyuk.dnd.domain.core.race

import io.vbytsyuk.dnd.domain.core.StatBlock
import io.vbytsyuk.dnd.domain.core.language.Language.Common
import io.vbytsyuk.dnd.domain.core.language.Language.Elvish
import io.vbytsyuk.dnd.domain.core.language.LanguageChecker
import io.vbytsyuk.dnd.domain.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.core.proficiencies.Skills1
import io.vbytsyuk.dnd.domain.core.skills.Skill
import io.vbytsyuk.dnd.domain.core.units.Distance
import io.vbytsyuk.dnd.domain.core.units.Size
import io.vbytsyuk.dnd.domain.core.units.Speed
import io.vbytsyuk.dnd.domain.core.units.feet
import io.vbytsyuk.dnd.domain.core.weapon.HandCrossbow
import io.vbytsyuk.dnd.domain.core.weapon.Longbow
import io.vbytsyuk.dnd.domain.core.weapon.Longsword
import io.vbytsyuk.dnd.domain.core.weapon.Rapier
import io.vbytsyuk.dnd.domain.core.weapon.Shortbow
import io.vbytsyuk.dnd.domain.core.weapon.Shortsword
import io.vbytsyuk.dnd.domain.core.weapon.WeaponChecker

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
