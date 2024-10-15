package io.vbytsyuk.dnd.domain.units.wallet

import io.vbytsyuk.dnd.domain.core.units.CoinType.COPPER
import io.vbytsyuk.dnd.domain.core.units.CoinType.GOLD
import io.vbytsyuk.dnd.domain.core.units.CoinType.PLATINUM
import io.vbytsyuk.dnd.domain.core.units.CoinType.SILVER
import io.vbytsyuk.dnd.domain.core.units.Coins
import io.vbytsyuk.dnd.domain.core.units.Wallet
import io.vbytsyuk.dnd.test.T
import kotlin.test.Test

class WalletPlusTest : T<Pair<Wallet, Coins>, Wallet> {

    @Test
    fun test_Wallet_plus() = check()

    override val dataSet = listOf(
        T.Data(
            name = "Add empty Coins to empty Wallet",
            input = Wallet() to Coins(0, COPPER),
            output = Wallet(),
        ),
        T.Data(
            name = "Add 5 copper to empty Wallet",
            input = Wallet() to Coins(5, COPPER),
            output = Wallet(copper = 5),
        ),
        T.Data(
            name = "Add 10 copper to empty Wallet",
            input = Wallet() to Coins(10, COPPER),
            output = Wallet(copper = 10),
        ),
        T.Data(
            name = "Add 5 silver to empty Wallet",
            input = Wallet() to Coins(5, SILVER),
            output = Wallet(silver = 5),
        ),
        T.Data(
            name = "Add 10 silver to empty Wallet",
            input = Wallet() to Coins(10, SILVER),
            output = Wallet(silver = 10),
        ),
        T.Data(
            name = "Add 5 gold to empty Wallet",
            input = Wallet() to Coins(5, GOLD),
            output = Wallet(gold = 5),
        ),
        T.Data(
            name = "Add 10 gold to empty Wallet",
            input = Wallet() to Coins(10, GOLD),
            output = Wallet(gold = 10),
        ),
        T.Data(
            name = "Add 5 platinum to empty Wallet",
            input = Wallet() to Coins(5, PLATINUM),
            output = Wallet(platinum = 5),
        ),
        T.Data(
            name = "Add 10 platinum to empty Wallet",
            input = Wallet() to Coins(10, PLATINUM),
            output = Wallet(platinum = 10),
        ),
        T.Data(
            name = "Add 15 silver to Wallet[gold: 6, silver: 20, copper: 36]",
            input = Wallet(gold = 6, silver = 20, copper = 36) to Coins(15, SILVER),
            output = Wallet(gold = 6, silver = 35, copper = 36),
        ),
    )

    override fun act(input: Pair<Wallet, Coins>): Wallet = input.first + input.second
}
