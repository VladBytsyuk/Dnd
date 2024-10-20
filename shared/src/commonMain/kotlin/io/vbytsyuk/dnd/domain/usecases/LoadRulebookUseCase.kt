package io.vbytsyuk.dnd.domain.usecases

import io.vbytsyuk.dnd.domain.Rulebook
import io.vbytsyuk.dnd.domain.ability.score.AbilityScore
import io.vbytsyuk.dnd.domain.alignment.Alignment
import io.vbytsyuk.dnd.domain.condition.Condition
import io.vbytsyuk.dnd.domain.damage.type.DamageType
import io.vbytsyuk.dnd.domain.language.Language
import io.vbytsyuk.dnd.domain.magic.school.MagicSchool
import io.vbytsyuk.dnd.domain.rule.Rule
import io.vbytsyuk.dnd.domain.rule.section.RuleSection
import io.vbytsyuk.dnd.domain.weapon.property.WeaponProperty

class LoadRulebookUseCase(
    private val conditionLoadUseCase: LoadUseCase<Condition>,
    private val damageTypeLoadUseCase: LoadUseCase<DamageType>,
    private val weaponPropertyLoadUseCase: LoadUseCase<WeaponProperty>,
    private val alignmentsLoadUseCase: LoadUseCase<Alignment>,
    private val magicSchoolsLoadUseCase: LoadUseCase<MagicSchool>,
    private val languagesLoadUseCase: LoadUseCase<Language>,
    private val abilityScoresLoadUseCase: LoadUseCase<AbilityScore>,
    private val ruleSectionsLoadUseCase: LoadUseCase<RuleSection>,
    private val rulesLoadUseCase: LoadUseCase<Rule>,
) {

    suspend operator fun invoke(): Rulebook {
        val conditions = conditionLoadUseCase()
        val damageTypes = damageTypeLoadUseCase()
        val weaponProperties = weaponPropertyLoadUseCase()
        val alignments = alignmentsLoadUseCase()
        val magicSchools = magicSchoolsLoadUseCase()
        val languages = languagesLoadUseCase()
        val abilityScores = abilityScoresLoadUseCase()
        ruleSectionsLoadUseCase()
        val rules = rulesLoadUseCase()
        return Rulebook(
            conditions = conditions,
            damageTypes = damageTypes,
            weaponProperties = weaponProperties,
            alignments = alignments,
            magicSchools = magicSchools,
            languages = languages,
            abilityScores = abilityScores,
            rules = rules,
        )
    }
}
