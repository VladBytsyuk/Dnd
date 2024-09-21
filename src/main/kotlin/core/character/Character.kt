package io.vbytsyuk.dnd.core.character

import io.vbytsyuk.dnd.core.*
import io.vbytsyuk.dnd.core.background.Background
import io.vbytsyuk.dnd.core.`class`.Class
import io.vbytsyuk.dnd.core.equipment.Equipment
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.calculateProficiencyBonus
import io.vbytsyuk.dnd.core.race.Race
import io.vbytsyuk.dnd.core.skills.Skill
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.Perception
import io.vbytsyuk.dnd.core.units.*
import io.vbytsyuk.dnd.core.weapon.Weapon
import io.vbytsyuk.dnd.core.weapon.Weapon.RangeType.RANGED

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
) {

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

    val passivePerception: StatValue = 10 + statBlock.modifier(StatType.WIS).value +
            proficiencyBonus.takeModifierIf { Perception in proficiencies.skills }.value

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

//    fun rollAttack(weapon: Weapon): Triple<Int, Pair<Hp, Damage.Type>, List<Trait>> {
//        require(equipment[weapon]?.isEquipped == true)
//        val strModifier = statBlock.modifier(StatType.STR)
//        val dexModifier = statBlock.modifier(StatType.DEX)
//        val rawAttackModifier = when {
//            weapon.rangeType == RANGED || weapon.isFinesse && dexModifier > strModifier -> dexModifier
//            else -> strModifier
//        }
//        val isProficient = proficiencies.weapons.check(weapon)
//        val attackModifier = rawAttackModifier + proficiencyBonus.takeModifierIf { isProficient }
//        val attackRolledValue = Dice.D20.valuesRange.random() + attackModifier.value
//        val damage = (1..weapon.damage.amount)
//            .fold(initial = 0) { acc, _ -> acc + weapon.damage.dice.valuesRange.random() }.hp + rawAttackModifier.value
//        val traits = emptyList<Trait>()
//        return Triple(attackRolledValue, damage to weapon.damage.type, traits)
//    }
}
