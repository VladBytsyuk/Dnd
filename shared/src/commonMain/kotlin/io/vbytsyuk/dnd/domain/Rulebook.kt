package io.vbytsyuk.dnd.domain

import io.vbytsyuk.dnd.domain.ability.score.AbilityScore
import io.vbytsyuk.dnd.domain.alignment.Alignment
import io.vbytsyuk.dnd.domain.background.Background
import io.vbytsyuk.dnd.domain.condition.Condition
import io.vbytsyuk.dnd.domain.damage.type.DamageType
import io.vbytsyuk.dnd.domain.equipment.base.Equipment
import io.vbytsyuk.dnd.domain.equipment.category.EquipmentCategory
import io.vbytsyuk.dnd.domain.language.Language
import io.vbytsyuk.dnd.domain.magic.school.MagicSchool
import io.vbytsyuk.dnd.domain.proficiency.Proficiency
import io.vbytsyuk.dnd.domain.rule.base.Rule
import io.vbytsyuk.dnd.domain.rule.section.RuleSection
import io.vbytsyuk.dnd.domain.skill.Skill
import io.vbytsyuk.dnd.domain.weapon.property.WeaponProperty

data class Rulebook(
    val conditions: List<Condition>,
    val damageTypes: List<DamageType>,
    val weaponProperties: List<WeaponProperty>,
    val alignments: List<Alignment>,
    val magicSchools: List<MagicSchool>,
    val languages: List<Language>,
    val abilityScores: List<AbilityScore>,
    val skills: List<Skill>,
    val equipmentCategories: List<EquipmentCategory>,
    val equipments: List<Equipment>,
    val backgrounds: List<Background>,
    val rules: List<Rule>,
    val ruleSections: List<RuleSection>,
    val proficiencies: List<Proficiency>,
) {

    override fun toString(): String = """
        Proficiencies:
            $proficiencies
    """.trimIndent()
}
