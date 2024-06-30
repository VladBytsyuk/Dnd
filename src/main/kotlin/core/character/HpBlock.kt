package io.vbytsyuk.dnd.core.character

import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.units.Hp
import io.vbytsyuk.dnd.core.units.calculateMaximumHp
import io.vbytsyuk.dnd.core.units.max
import io.vbytsyuk.dnd.core.units.min

data class HpBlock(
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

    fun addHp(hp: Hp): HpBlock = copy(
        currentHp = min(currentHp + hp, maxHp)
    )

    fun addTemporaryHp(hp: Hp): HpBlock = copy(
        temporaryHp = temporaryHp + hp
    )

    fun removeHp(hp: Hp): HpBlock = when {
        temporaryHp < hp -> copy(
            temporaryHp = Hp(0),
            currentHp = max(currentHp - (hp - temporaryHp), Hp(0)),
        )
        else -> copy(temporaryHp = temporaryHp - hp)
    }
}

val Character.maxHp: Hp get() = calculateMaximumHp(
    hpDice = `class`.hpDice,
    constitutionModifier = statBlock.modifier(StatType.CON),
    level = level,
    traits = traits,
)