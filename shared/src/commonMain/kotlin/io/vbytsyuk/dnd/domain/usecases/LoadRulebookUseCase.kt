package io.vbytsyuk.dnd.domain.usecases

import io.vbytsyuk.dnd.domain.Rulebook
import io.vbytsyuk.dnd.domain.alignment.Alignment
import io.vbytsyuk.dnd.domain.condition.Condition
import io.vbytsyuk.dnd.domain.damage.type.DamageType
import io.vbytsyuk.dnd.domain.language.Language
import io.vbytsyuk.dnd.domain.magic.school.MagicSchool
import io.vbytsyuk.dnd.domain.weapon.property.WeaponProperty

class LoadRulebookUseCase(
    private val conditionLoadUseCase: LoadUseCase<Condition>,
    private val damageTypeLoadUseCase: LoadUseCase<DamageType>,
    private val weaponPropertyLoadUseCase: LoadUseCase<WeaponProperty>,
    private val alignmentsLoadUseCaseImpl: LoadUseCase<Alignment>,
    private val magicSchoolsLoadUseCaseImpl: LoadUseCase<MagicSchool>,
    private val languagesLoadUseCaseImpl: LoadUseCase<Language>,
) {

    suspend operator fun invoke(): Rulebook {
        val conditions = conditionLoadUseCase()
        val damageTypes = damageTypeLoadUseCase()
        val weaponProperties = weaponPropertyLoadUseCase()
        val alignments = alignmentsLoadUseCaseImpl()
        val magicSchools = magicSchoolsLoadUseCaseImpl()
        val languages = languagesLoadUseCaseImpl()
        return Rulebook(
            conditions = conditions,
            damageTypes = damageTypes,
            weaponProperties = weaponProperties,
            alignments = alignments,
            magicSchools = magicSchools,
            languages = languages,
        )
    }
}
