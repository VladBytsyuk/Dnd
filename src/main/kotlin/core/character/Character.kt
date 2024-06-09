package io.vbytsyuk.dnd.core.character

import io.vbytsyuk.dnd.core.Modifier
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.background.Background
import io.vbytsyuk.dnd.core.`class`.Class
import io.vbytsyuk.dnd.core.equipment.Equipment
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.calculateProficiencyBonus
import io.vbytsyuk.dnd.core.race.Race
import io.vbytsyuk.dnd.core.units.Alignment
import io.vbytsyuk.dnd.core.units.Level

class Character(
    val name: String,
    val race: Race,
    val `class`: Class,
    val aliignment: Alignment,
    val background: Background,
    val initialRawStatBlock: StatBlock,
    val level: Level,
    val equipment: Equipment,
) {

    val statBlock: StatBlock = initialRawStatBlock +
            race.bonusStatBlock

    var hpBlock: HpBlock = HpBlock(this)

    val proficiencyBonus: Modifier = calculateProficiencyBonus(level)

    val proficiencies: Proficiencies = race.proficiencies + `class`.proficiencies + background.proficiencies
}
