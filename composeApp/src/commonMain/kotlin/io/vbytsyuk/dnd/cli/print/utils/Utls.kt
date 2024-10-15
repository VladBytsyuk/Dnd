package io.vbytsyuk.dnd.cli.print.utils

import io.vbytsyuk.dnd.domain.Dice
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.sheet.Sheet
import io.vbytsyuk.dnd.domain.units.Damage
import io.vbytsyuk.dnd.domain.units.Wallet

fun Proficiencies.toStringOutput() = """
    Proficiencies:
        Armor: ${armor.toStringOutput()}
        Weapon: ${weapons.toStringOutput()}
        Tools: ${tools.toStringOutput()}
        Languages: ${languages.toStringOutput()}
""".trimIndent()

fun Wallet.toStringOutput(): String = "$copper copper, $silver silver, $gold gold, $platinum platinum"

fun Sheet.Equipment.toStringOutput(): String = "Equipment: ${items.joinToString { it }}"

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
