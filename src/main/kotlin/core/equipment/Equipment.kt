package io.vbytsyuk.dnd.core.equipment

interface Item

fun Item.equipped(count: Int = 1): Pair<Item, Equipment.Data> =
    this to Equipment.Data(count = count, isEquipped = true)

fun Item.unequipped(count: Int = 1): Pair<Item, Equipment.Data> =
    this to Equipment.Data(count = count, isEquipped = false)

class Equipment(vararg items: Pair<Item, Equipment.Data>) : HashMap<Item, Equipment.Data>(items.toMap()) {

    data class Data(val count: Int = 1, val isEquipped: Boolean)

    override fun toString() = entries.joinToString { (item, data) ->
        "$item${if (data.count == 1) "" else " (${data.count})"}${if (data.isEquipped) "*" else ""}"
    }
}
