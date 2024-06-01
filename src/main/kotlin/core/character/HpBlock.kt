package io.vbytsyuk.dnd.core.character

import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.units.Hp
import io.vbytsyuk.dnd.core.units.calculateMaximumHp

class HpBlock(
    val currentHp: Hp,
    val maxHp: Hp,
    val temporaryHp: Hp,
) {

    constructor(character: Character) : this(
        currentHp = character.maxHp,
        maxHp = character.maxHp,
        temporaryHp = Hp(0),
    )

    override fun toString() = "${currentHp.value}${if (temporaryHp.value > 0) "+${temporaryHp.value}" else ""}/${maxHp}"

}

val Character.maxHp: Hp get() = calculateMaximumHp(
    hpDice = `class`.hpDice,
    constitutionModifier = statBlock.modifier(StatType.CON),
    level = level,
)