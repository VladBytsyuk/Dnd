package io.vbytsyuk.dnd.core.tools

import io.vbytsyuk.dnd.core.proficiencies.Skills
import io.vbytsyuk.dnd.core.skills.Skill
import io.vbytsyuk.dnd.core.skills.Skill.*
import io.vbytsyuk.dnd.core.units.Coins
import io.vbytsyuk.dnd.core.units.Weight
import io.vbytsyuk.dnd.core.units.gold
import io.vbytsyuk.dnd.core.units.lb

sealed class Tools(
    val cost: Coins,
    val weight: Weight,
    val description: String,
)

data object ThievesTools : Tools(
    cost = 25.gold,
    weight = 1.lb,
    description = """
        This set of tools includes a small file, a set of lock picks, a small mirror mounted on a metal handle,
        a set of narrow-bladed scissors, and a pair of pliers.
        Proficiency with these tools lets you add your proficiency bonus to any ability checks you make to disarm
        traps or open locks.
    """.trimIndent(),
)

data object AlchemistSupplies : Tools(
    cost = 50.gold,
    weight = 8.lb,
    description = """
        These special tools include the items needed to pursue a craft or trade. Proficiency with a set of artisan's 
        tools lets you add your proficiency bonus to any ability checks you make using the tools in your craft. 
        Each type of artisan's tools requires a separate proficiency.
    """.trimIndent(),
)