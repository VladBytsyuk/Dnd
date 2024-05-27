package io.vbytsyuk.dnd.core.money

enum class CoinType(
    val coefficient: Int,
) {
    COPPER(coefficient = 1),
    SILVER(coefficient = 10),
    GOLD(coefficient = 100),
    PLATINUM(coefficient = 1000);
}

data class Coins(val amount: Int, val type: CoinType) {

    init {
        require(amount >= 0) {
            "Coins [$this] should has only positive amount of coins."
        }
    }
}

val Int.copper get() = Coins(this, CoinType.COPPER)
val Int.silver get() = Coins(this, CoinType.SILVER)
val Int.gold get() = Coins(this, CoinType.GOLD)
val Int.platinum get() = Coins(this, CoinType.PLATINUM)
