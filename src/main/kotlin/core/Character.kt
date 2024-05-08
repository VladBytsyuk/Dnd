package io.vbytsyuk.dnd.core

import io.vbytsyuk.dnd.core.race.Race

data class Character(
    val name: String,
    val race: Race,
    val `class`: Class,
    val statBlock: StatBlock,
    val level: Level,
) {
    val maxHp: Hp = calculateMaximumHp(
        hpDice = `class`.hpDice,
        constitutionModifier = statBlock.constitution.modifier,
        level = level,
    )
}
