package io.vbytsyuk.dnd.core.character

import io.vbytsyuk.dnd.core.*
import io.vbytsyuk.dnd.core.background.Background
import io.vbytsyuk.dnd.core.`class`.Class
import io.vbytsyuk.dnd.core.equipment.Equipment
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.calculateProficiencyBonus
import io.vbytsyuk.dnd.core.race.Race
import io.vbytsyuk.dnd.core.skills.Skill
import io.vbytsyuk.dnd.core.units.*

class Character(
    val name: String,
    val race: Race,
    val `class`: Class,
    val alignment: Alignment,
    val background: Background,
    val initialRawStatBlock: StatBlock,
    val level: Level,
    val equipment: Equipment,
    // archtype
    // exp
    // hit dices
    // saving throws from death
) {

    val statBlock: StatBlock = initialRawStatBlock +
            race.bonusStatBlock

    var hpBlock: HpBlock = HpBlock(this)

    val proficiencyBonus: Modifier = calculateProficiencyBonus(level)

    val proficiencies: Proficiencies = race.proficiencies + `class`.proficiencies + background.proficiencies

    val passivePerception: StatValue = 10 +
            statBlock.modifier(StatType.WIS).value +
            (proficiencyBonus.value.takeIf { Skill.Wisdom.Perception in proficiencies.skills } ?: 0)

    val traits: List<Trait> get() = race.traits

    fun rollSavingThrow(type: StatType): Pair<Int, List<Trait>> {
        val traits = traits.filterWithSavingThrow(type)
        val modifierValue = savingThrows[type]?.modifier?.value ?: 0
        val rolledValue = Dice.D20.valuesRange.random() + modifierValue
        return rolledValue to traits
    }

    fun rollSkillCheck(skill: Skill): Pair<Int, List<Trait>> {
        val traits = traits.filterWithSkill(skill)
        val modifierValue = skills[skill]?.modifier?.value ?: 0
        val rolledValue = Dice.D20.valuesRange.random() + modifierValue
        return rolledValue to traits
    }


}
