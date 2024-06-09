package io.vbytsyuk.dnd.core.tools

import io.vbytsyuk.dnd.core.equipment.Item
import io.vbytsyuk.dnd.core.units.Coins
import io.vbytsyuk.dnd.core.units.Weight
import io.vbytsyuk.dnd.core.units.gold
import io.vbytsyuk.dnd.core.units.lb

sealed class Tools(
    val cost: Coins,
    val weight: Weight,
    val description: String,
) : Item {
    override val name = this::class.simpleName.toString()
}

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

data object NavigatorsTools : Tools(
    cost = 25.gold,
    weight = 2.lb,
    description = """
        This set of instruments is used for navigation at sea. Proficiency with navigator's tools lets you chart a 
        ship's course and follow navigation charts. In addition, these tools allow you to add your proficiency bonus to 
        any ability check you make to avoid getting lost at sea.
    """.trimIndent(),
)
