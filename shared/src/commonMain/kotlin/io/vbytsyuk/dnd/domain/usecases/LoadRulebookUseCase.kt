package io.vbytsyuk.dnd.domain.usecases

import io.vbytsyuk.dnd.domain.Rulebook
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

class LoadRulebookUseCase(
    private val conditionLoadUseCase: LoadUseCase<Condition>,
    private val damageTypeLoadUseCase: LoadUseCase<DamageType>,
    private val weaponPropertyLoadUseCase: LoadUseCase<WeaponProperty>,
    private val alignmentsLoadUseCase: LoadUseCase<Alignment>,
    private val magicSchoolsLoadUseCase: LoadUseCase<MagicSchool>,
    private val languagesLoadUseCase: LoadUseCase<Language>,
    private val abilityScoresLoadUseCase: LoadUseCase<AbilityScore>,
    private val skillsLoadUseCase: LoadUseCase<Skill>,
    private val equipmentCategoriesLoadUseCase: LoadUseCase<EquipmentCategory>,
    private val equipmentsLoadUseCase: LoadUseCase<Equipment>,
    private val backgroundsLoadUseCase: LoadUseCase<Background>,
    private val ruleSectionsLoadUseCase: LoadUseCase<RuleSection>,
    private val rulesLoadUseCase: LoadUseCase<Rule>,
    private val proficienciesLoadUseCase: LoadUseCase<Proficiency>,
) {

    suspend operator fun invoke(): Rulebook {
        val conditions = conditionLoadUseCase()
        val damageTypes = damageTypeLoadUseCase()
        val weaponProperties = weaponPropertyLoadUseCase()
        val alignments = alignmentsLoadUseCase()
        val magicSchools = magicSchoolsLoadUseCase()
        val languages = languagesLoadUseCase()
        val abilityScores = abilityScoresLoadUseCase()
        val skills = skillsLoadUseCase()
        val equipmentCategories = equipmentCategoriesLoadUseCase()
        val equipments = equipmentsLoadUseCase()
        val rules = rulesLoadUseCase()
        val ruleSections = ruleSectionsLoadUseCase()
        val backgrounds = backgroundsLoadUseCase()
        val proficiencies = proficienciesLoadUseCase()
        return Rulebook(
            conditions = conditions,
            damageTypes = damageTypes,
            weaponProperties = weaponProperties,
            alignments = alignments,
            magicSchools = magicSchools,
            languages = languages,
            abilityScores = abilityScores,
            skills = skills,
            equipmentCategories = equipmentCategories,
            equipments = equipments,
            rules = rules,
            backgrounds = backgrounds,
            ruleSections = ruleSections,
            proficiencies = proficiencies,
        )
    }
}
