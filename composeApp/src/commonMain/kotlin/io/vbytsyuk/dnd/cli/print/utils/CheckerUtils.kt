package io.vbytsyuk.dnd.cli.print.utils

import io.vbytsyuk.dnd.domain.core.armor.ArmorChecker
import io.vbytsyuk.dnd.domain.core.language.LanguageChecker
import io.vbytsyuk.dnd.domain.core.tools.ToolsChecker
import io.vbytsyuk.dnd.domain.core.weapon.WeaponChecker

fun ArmorChecker.toStringOutput(): String {
    val armorTypesMap = mapOf(
        "Light" to light,
        "Medium" to medium,
        "Heavy" to heavy,
        "Shield" to shield
    )
    return (armorTypesMap.filter { it.value }.keys + specific).joinToString()
}

fun WeaponChecker.toStringOutput(): String {
    val weaponTypesMap = mapOf("Simple" to simple, "Matrial" to matrial)
    return (weaponTypesMap.filter { it.value }.keys + specific).joinToString()
}

fun ToolsChecker.toStringOutput(): String = specific.joinToString()

fun LanguageChecker.toStringOutput(): String = specific.joinToString()
