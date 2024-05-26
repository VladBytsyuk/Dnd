package io.vbytsyuk.dnd.core.money

import io.vbytsyuk.dnd.core.T
import org.junit.jupiter.api.Test

class WalletNormalizeTest : T<Wallet, Wallet> {

    @Test
    fun `test Wallet normalize`() = check()

    override val dataSet = listOf(
        T.Data(name = "Empty Wallet", input = Wallet(), output = Wallet()),
        T.Data(name = "1 copper", input = Wallet(copper = 1), output = Wallet(copper = 1)),
        T.Data(name = "5 copper", input = Wallet(copper = 5), output = Wallet(copper = 5)),
        T.Data(name = "10 copper", input = Wallet(copper = 10), output = Wallet(silver = 1)),
        T.Data(name = "15 copper", input = Wallet(copper = 15), output = Wallet(silver = 1, copper = 5)),
        T.Data(name = "1 silver", input = Wallet(silver = 1), output = Wallet(silver = 1)),
        T.Data(name = "5 silver", input = Wallet(silver = 5), output = Wallet(silver = 5)),
        T.Data(name = "10 silver", input = Wallet(silver = 10), output = Wallet(gold = 1)),
        T.Data(name = "15 silver", input = Wallet(silver = 15), output = Wallet(gold = 1, silver = 5)),
        T.Data(name = "1 gold", input = Wallet(gold = 1), output = Wallet(gold = 1)),
        T.Data(name = "5 gold", input = Wallet(gold = 5), output = Wallet(gold = 5)),
        T.Data(name = "10 gold", input = Wallet(gold = 10), output = Wallet(platinum = 1)),
        T.Data(name = "15 gold", input = Wallet(gold = 15), output = Wallet(platinum = 1, gold = 5)),
        T.Data(name = "1 platinum", input = Wallet(platinum = 1), output = Wallet(platinum = 1)),
        T.Data(name = "5 platinum", input = Wallet(platinum = 5), output = Wallet(platinum = 5)),
        T.Data(name = "10 platinum", input = Wallet(platinum = 10), output = Wallet(platinum = 10)),
        T.Data(name = "15 platinum", input = Wallet(platinum = 15), output = Wallet(platinum = 15)),
        T.Data(
            name = "123 456 copper",
            input = Wallet(copper = 123_456),
            output = Wallet(platinum = 123, gold = 4, silver = 5, copper = 6),
        ),
    )

    override fun act(input: Wallet): Wallet = input.normalize()
}
