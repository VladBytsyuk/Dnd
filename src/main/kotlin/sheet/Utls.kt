package io.vbytsyuk.dnd.sheet

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.armor.ArmorChecker
import io.vbytsyuk.dnd.core.language.LanguageChecker
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.tools.ToolsChecker
import io.vbytsyuk.dnd.core.units.Damage
import io.vbytsyuk.dnd.core.units.Wallet
import io.vbytsyuk.dnd.core.weapon.WeaponChecker

fun Sheet.Health.toHealthString() = "$currentHp${if (temporaryHp > 0) "(+$temporaryHp)" else ""}/$maxHp hp"

fun Sheet.Skills.Data.toDataString() = "$value($modifier), savingThrow = $savingThrow\t\t$skills"

fun Sheet.Skills.toSkillsString() = """
    Skills: Proficiency = $proficiencyBonus,
        STR = ${strength.toDataString()}
        DEX = ${dexterity.toDataString()}
        CON = ${constitution.toDataString()}
        INT = ${intelligence.toDataString()}
        WIS = ${wisdom.toDataString()}
        CHA = ${charisma.toDataString()}
""".trimIndent()

fun Proficiencies.toProficienciesString() = """
    Proficiencies:
        Armor: ${armor.toStringOutput()}
        Weapon: ${weapons.toStringOutput()}
        Tools: ${tools.toStringOutput()}
        Languages: ${languages.toStringOutput()}
""".trimIndent()

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

fun Wallet.toStringOutput(): String = "$copper copper, $silver silver, $gold gold, $platinum platinum"

fun List<Sheet.Attack>.toStringOutput(): String =
    "Attacks:\n${this.joinToString(separator = "\n") { "\t${it.toStringOutput()}" }}"

fun Sheet.Attack.toStringOutput(): String = "$weapon\t$modifier\t${damage.toStringOutput()}"

fun Damage.toStringOutput(): String = entries.joinToString(separator = " + ") { entry ->
    entry.dices.joinToString(separator = "+") { dices ->
        if (dices.dice == Dice.D1) "${dices.amount}" else "${dices.amount}${dices.dice}"
    } + " " + entry.type.toString()
}

fun Sheet.Personality.toStringOutput(): String = """
    Personality:
        Trait: $trait
        Ideal: $ideal
        Bond: $bond
        Flaw: $flaw
""".trimIndent()