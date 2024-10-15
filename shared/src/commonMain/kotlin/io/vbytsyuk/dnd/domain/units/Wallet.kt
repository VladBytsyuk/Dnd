package io.vbytsyuk.dnd.domain.units

import io.vbytsyuk.dnd.domain.units.CoinType.COPPER
import io.vbytsyuk.dnd.domain.units.CoinType.GOLD
import io.vbytsyuk.dnd.domain.units.CoinType.PLATINUM
import io.vbytsyuk.dnd.domain.units.CoinType.SILVER


data class Wallet(
    val copper: Int = 0,
    val silver: Int = 0,
    val gold: Int = 0,
    val platinum: Int = 0,
) {

    init {
        require(copper >= 0 && silver >= 0 && gold >= 0 && platinum >= 0) {
            "Wallet [$this] should has only positive amount of coins."
        }
    }

    override fun toString() = buildString {
        append("Wallet [")
        val coinsString = listOf("platinum" to platinum, "gold" to gold, "silver" to silver, "copper" to copper)
            .filter { it.second > 0 }
            .joinToString(separator = ", ") { (name, value) -> "$name: $value" }
        if (coinsString.isBlank()) append("empty") else append(coinsString)
        append("]")
    }

    operator fun plus(coins: Coins): Wallet = Wallet(
        copper = copper + (if (coins.type == COPPER) coins.amount else 0),
        silver = silver + (if (coins.type == SILVER) coins.amount else 0),
        gold = gold + (if (coins.type == GOLD) coins.amount else 0),
        platinum = platinum + (if (coins.type == PLATINUM) coins.amount else 0),
    )

    fun normalize(): Wallet {
        var copper = copper * COPPER.coefficient +
                silver * SILVER.coefficient +
                gold * GOLD.coefficient +
                platinum * PLATINUM.coefficient

        val platinum = copper / PLATINUM.coefficient
        copper -= platinum * PLATINUM.coefficient

        val gold = copper / GOLD.coefficient
        copper -= gold * GOLD.coefficient

        val silver = copper / SILVER.coefficient
        copper -= silver * SILVER.coefficient

        return Wallet(
            copper = copper,
            silver = silver,
            gold = gold,
            platinum = platinum
        )
    }
}

fun Wallet(coins: Coins): Wallet = Wallet() + coins
