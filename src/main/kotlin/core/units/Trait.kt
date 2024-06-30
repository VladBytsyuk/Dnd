package io.vbytsyuk.dnd.core.units

import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.skills.Skill
import io.vbytsyuk.dnd.core.util.Checker

data class Trait(
    val name: String,
    val description: String,
    val affect: Affect = Affect(),
)

data class Affect(
    val savingThrows: Checker<StatType> = Checker { false },
    val skills: Checker<Skill> = Checker { false },
    val resistances: Checker<Damage.Type> = Checker { false },
    val spells: Map<Spell, StatType> = emptyMap(),
    val hpForLevel: Int = 0,
)

fun List<Trait>.filterWithSavingThrow(type: StatType): List<Trait> =
    filter { it.affect.savingThrows.check(type) }

fun List<Trait>.filterWithSkill(skill: Skill): List<Trait> =
    filter { it.affect.skills.check(skill) }

fun List<Trait>.filterWithHpForLevelAffect(): List<Trait> =
    filter { it.affect.hpForLevel != 0 }
