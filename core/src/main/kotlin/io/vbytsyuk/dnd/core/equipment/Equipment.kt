package io.vbytsyuk.dnd.core.equipment

import io.vbytsyuk.dnd.core.armor.Armor

interface Item {
    val name: String
}

fun Item(name: String): Item = object : Item {
    override val name = name
}

fun Item.equipped(count: Int = 1): Pair<Item, Equipment.Data> =
    this to Equipment.Data(count = count, isEquipped = true)

fun Item.unequipped(count: Int = 1): Pair<Item, Equipment.Data> =
    this to Equipment.Data(count = count, isEquipped = false)

class Equipment(vararg items: Pair<Item, Data>) : HashMap<Item, Equipment.Data>(items.toMap()) {

    data class Data(val count: Int = 1, val isEquipped: Boolean)

    override fun toString() = entries
        .sortedByDescending { (_, data) -> data.isEquipped }
        .joinToString { it.toSimpleString() }

    fun toStringList() = entries
        .sortedByDescending { (_, data) -> data.isEquipped }
        .map { it.toSimpleString() }

    private fun MutableMap.MutableEntry<Item, Data>.toSimpleString() =
        "${key.name}${if (value.count == 1) "" else " (${value.count})"}${if (value.isEquipped) "*" else ""}"

    val equippedArmor: List<Armor> get() = entries
        .filter { (item, data) -> item is Armor && data.isEquipped }
        .map { (item, _) -> item as Armor }
}
