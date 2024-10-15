package io.vbytsyuk.dnd.domain.character

import io.vbytsyuk.dnd.domain.Modifier
import io.vbytsyuk.dnd.domain.StatBlock
import io.vbytsyuk.dnd.domain.StatType
import io.vbytsyuk.dnd.domain.StatValue
import io.vbytsyuk.dnd.domain.background.Background
import io.vbytsyuk.dnd.domain.`class`.Class
import io.vbytsyuk.dnd.domain.equipment.Equipment
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.proficiencies.calculateProficiencyBonus
import io.vbytsyuk.dnd.domain.race.Race
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Perception
import io.vbytsyuk.dnd.domain.units.Alignment
import io.vbytsyuk.dnd.domain.units.Exp
import io.vbytsyuk.dnd.domain.units.Hp
import io.vbytsyuk.dnd.domain.units.Level
import io.vbytsyuk.dnd.domain.units.Trait
import io.vbytsyuk.dnd.domain.units.Wallet
import io.vbytsyuk.dnd.domain.units.calculateMaximumHp

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
