package io.vbytsyuk.dnd.domain.armor

import io.vbytsyuk.dnd.domain.util.Checker

class ArmorChecker(
    val light: Boolean = false,
    val medium: Boolean = false,
    val heavy: Boolean = false,
    val shield: Boolean = false,
    specific: Set<Armor> = emptySet(),
) : Checker<Armor> {

    val specific: Set<Armor> = specific.filterNot(::checkType).toSet()

    override fun check(arg: Armor): Boolean =
        arg in specific || checkType(arg)

    private fun checkType(arg: Armor) = when (arg.type) {
        is Armor.Type.Light -> light
        is Armor.Type.Medium -> medium
        is Armor.Type.Heavy -> heavy
        Armor.Type.Shield -> shield
    }

    operator fun plus(other: ArmorChecker): ArmorChecker = ArmorChecker(
        light = light || other.light,
        medium = medium || other.medium,
        heavy = heavy || other.heavy,
        shield = shield || other.shield,
        specific = specific + other.specific,
    )

    companion object {

        fun Full() = ArmorChecker(
            light = true,
            medium = true,
            heavy = true,
            shield = true,
            specific = emptySet(),
        )
    }
}
