package io.vbytsyuk.dnd.core.character

import io.vbytsyuk.dnd.core.Modifier
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.StatValue
import io.vbytsyuk.dnd.core.background.Background
import io.vbytsyuk.dnd.core.`class`.Class
import io.vbytsyuk.dnd.core.equipment.Equipment
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.calculateProficiencyBonus
import io.vbytsyuk.dnd.core.race.Race
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.Perception
import io.vbytsyuk.dnd.core.units.Alignment
import io.vbytsyuk.dnd.core.units.Exp
import io.vbytsyuk.dnd.core.units.Hp
import io.vbytsyuk.dnd.core.units.Level
import io.vbytsyuk.dnd.core.units.Trait
import io.vbytsyuk.dnd.core.units.Wallet
import io.vbytsyuk.dnd.core.units.calculateMaximumHp

data class Character(
    val name: String,
    val race: Race,
    val `class`: Class,
    val alignment: Alignment,
    val background: Background,
    val initialRawStatBlock: StatBlock,
    val exp: Exp,
    val equipment: Equipment,
    val wallet: Wallet = Wallet(background.startCoins),
    val personality: Personality,
) {

    data class Personality(
        val trait: String,
        val ideal: String,
        val bond: String,
        val flaw: String,
    )

    val level: Level get() = exp.level

    val statBlock: StatBlock = initialRawStatBlock +
            race.bonusStatBlock

    val maxHp: Hp = calculateMaximumHp(
        hpDice = `class`.hpDice,
        constitutionModifier = statBlock.modifier(StatType.CON),
        level = level,
        traits = traits,
    )

    val proficiencyBonus: Modifier = calculateProficiencyBonus(level)

    val proficiencies: Proficiencies = race.proficiencies + `class`.proficiencies + background.proficiencies

    val passivePerception: StatValue = BASE_PERCEPTION + statBlock.modifier(StatType.WIS).value +
            proficiencyBonus.takeModifierIf { Perception in proficiencies.skills }.value

    val traits: List<Trait> get() = race.traits

    companion object {

        private const val BASE_PERCEPTION = 10
    }
}
