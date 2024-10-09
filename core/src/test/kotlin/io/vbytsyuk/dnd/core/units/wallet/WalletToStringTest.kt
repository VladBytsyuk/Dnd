package io.vbytsyuk.dnd.core.units.wallet

import io.vbytsyuk.dnd.core.units.Wallet
import io.vbytsyuk.dnd.test.T
import org.junit.jupiter.api.Test

class WalletToStringTest : T<Wallet, String> {

    @Test
    fun `test Wallet toString`() = check()

    override val dataSet = listOf(
        T.Data(name = "Empty Wallet", input = Wallet(), output = "Wallet [empty]"),
        T.Data(name = "1 copper", input = Wallet(copper = 1), output = "Wallet [copper: 1]"),
        T.Data(name = "5 copper", input = Wallet(copper = 5), output = "Wallet [copper: 5]"),
        T.Data(name = "10 copper", input = Wallet(copper = 10), output = "Wallet [copper: 10]"),
        T.Data(name = "1 silver", input = Wallet(silver = 1), output = "Wallet [silver: 1]"),
        T.Data(name = "5 silver", input = Wallet(silver = 5), output = "Wallet [silver: 5]"),
        T.Data(name = "10 silver", input = Wallet(silver = 10), output = "Wallet [silver: 10]"),
        T.Data(name = "1 gold", input = Wallet(gold = 1), output = "Wallet [gold: 1]"),
        T.Data(name = "5 gold", input = Wallet(gold = 5), output = "Wallet [gold: 5]"),
        T.Data(name = "10 gold", input = Wallet(gold = 10), output = "Wallet [gold: 10]"),
        T.Data(name = "1 platinum", input = Wallet(platinum = 1), output = "Wallet [platinum: 1]"),
        T.Data(name = "5 platinum", input = Wallet(platinum = 5), output = "Wallet [platinum: 5]"),
        T.Data(name = "10 platinum", input = Wallet(platinum = 10), output = "Wallet [platinum: 10]"),
        T.Data(
            name = "5 copper, 3 silver",
            input = Wallet(copper = 5, silver = 3),
            output = "Wallet [silver: 3, copper: 5]",
        ),
        T.Data(
            name = "5 copper, 3 silver, 8 gold",
            input = Wallet(copper = 5, silver = 3, gold = 8),
            output = "Wallet [gold: 8, silver: 3, copper: 5]",
        ),
        T.Data(
            name = "5 copper, 3 silver, 8 gold, 4 platinum",
            input = Wallet(copper = 5, silver = 3, gold = 8, platinum = 4),
            output = "Wallet [platinum: 4, gold: 8, silver: 3, copper: 5]",
        ),
        T.Data(
            name = "3 silver, 8 gold, 4 platinum",
            input = Wallet(silver = 3, gold = 8, platinum = 4),
            output = "Wallet [platinum: 4, gold: 8, silver: 3]",
        ),
        T.Data(
            name = "5 copper, 3 silver, 8 gold, 4 platinum",
            input = Wallet(copper = 5, gold = 8, platinum = 4),
            output = "Wallet [platinum: 4, gold: 8, copper: 5]",
        ),
        T.Data(
            name = "5 copper, 3 silver, 4 platinum",
            input = Wallet(copper = 5, silver = 3, platinum = 4),
            output = "Wallet [platinum: 4, silver: 3, copper: 5]",
        ),
        T.Data(
            name = "8 gold, 4 platinum",
            input = Wallet(gold = 8, platinum = 4),
            output = "Wallet [platinum: 4, gold: 8]",
        ),
    )

    override fun act(input: Wallet): String = input.toString()
}
