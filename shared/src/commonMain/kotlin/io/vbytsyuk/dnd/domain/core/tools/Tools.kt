package io.vbytsyuk.dnd.domain.core.tools

import io.vbytsyuk.dnd.domain.core.equipment.Item
import io.vbytsyuk.dnd.domain.core.units.Coins
import io.vbytsyuk.dnd.domain.core.units.Weight
import io.vbytsyuk.dnd.domain.core.units.gold
import io.vbytsyuk.dnd.domain.core.units.lb

interface Tools : Item {

    val cost: Coins
    val weight: io.vbytsyuk.dnd.domain.core.units.Weight
    val description: String

    override val name get() = this::class.simpleName.toString()
}

data object ThievesTools : Tools {
    override val cost = 25.gold
    override val weight = 1.lb
    override val description = """
        This set of tools includes a small file, a set of lock picks, a small mirror mounted on a metal handle,
        a set of narrow-bladed scissors, and a pair of pliers.
        Proficiency with these tools lets you add your proficiency bonus to any ability checks you make to disarm
        traps or open locks.
    """.trimIndent()
}

data object NavigatorsTools : Tools {
    override val cost = 25.gold
    override val weight = 2.lb
    override val description = """
        This set of instruments is used for navigation at sea. Proficiency with navigator's tools lets you chart a 
        ship's course and follow navigation charts. In addition, these tools allow you to add your proficiency bonus to 
        any ability check you make to avoid getting lost at sea.
    """.trimIndent()
}
