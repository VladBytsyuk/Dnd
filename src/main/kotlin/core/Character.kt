package io.vbytsyuk.dnd.core

import io.vbytsyuk.dnd.core.race.Race

data class Character(
    val name: String,
    val race: Race,
    val `class`: Class,
    val initialRawStatBlock: StatBlock,
    val level: Level,
) {

    val statBlock: StatBlock = initialRawStatBlock + race.bonusStatBlock
    
    val maxHp: Hp = calculateMaximumHp(
        hpDice = `class`.hpDice,
        constitutionModifier = statBlock.modifier(StatType.CON),
        level = level,
    )

    val proficiencyBonus: Modifier = calculateProficiencyBonus(level)
}
