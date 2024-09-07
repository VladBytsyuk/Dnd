package io.vbytsyuk.dnd.core.weapon

import io.vbytsyuk.dnd.core.util.Checker

class WeaponChecker(
    val simple: Boolean = false,
    val matrial: Boolean = false,
    specific: Set<Weapon> = emptySet(),
) : Checker<Weapon> {

    val specific: Set<Weapon> = specific.filterNot(::checkType).toSet()

    override fun check(arg: Weapon): Boolean =
        arg in specific || checkType(arg)

    private fun checkType(arg: Weapon): Boolean = when (arg.proficiencyType) {
        Weapon.ProficiencyType.SIMPLE -> simple
        Weapon.ProficiencyType.MATRIAL -> matrial
    }

    operator fun plus(other: WeaponChecker): WeaponChecker = WeaponChecker(
        simple = simple || other.simple,
        matrial = matrial || other.matrial,
        specific = specific + other.specific,
    )

    companion object {

        fun Full() = WeaponChecker(simple = true, matrial = true, specific = emptySet())
    }
}