package io.vbytsyuk.dnd.di.modules

import io.vbytsyuk.dnd.data.RulebookRoomDatabase
import io.vbytsyuk.dnd.data.ability.score.AbilityScoresLoadUseCaseImpl
import io.vbytsyuk.dnd.data.ability.score.AbilityScoresReader
import io.vbytsyuk.dnd.data.ability.score.db.AbilityScoreDao
import io.vbytsyuk.dnd.data.ability.score.db.AbilityScoreRepository
import io.vbytsyuk.dnd.data.ability.score.json.AbilityScoreJsonParser
import io.vbytsyuk.dnd.data.alignment.AlignmentsLoadUseCaseImpl
import io.vbytsyuk.dnd.data.alignment.AlignmentsReader
import io.vbytsyuk.dnd.data.alignment.db.AlignmentDao
import io.vbytsyuk.dnd.data.alignment.db.AlignmentRepository
import io.vbytsyuk.dnd.data.alignment.json.AlignmentJsonParser
import io.vbytsyuk.dnd.data.condition.ConditionsLoadUseCaseImpl
import io.vbytsyuk.dnd.data.condition.ConditionsReader
import io.vbytsyuk.dnd.data.condition.db.ConditionDao
import io.vbytsyuk.dnd.data.condition.db.ConditionRepository
import io.vbytsyuk.dnd.data.condition.json.ConditionJsonParser
import io.vbytsyuk.dnd.data.damage.type.DamageTypesLoadUseCaseImpl
import io.vbytsyuk.dnd.data.damage.type.DamageTypesReader
import io.vbytsyuk.dnd.data.damage.type.db.DamageTypeDao
import io.vbytsyuk.dnd.data.damage.type.db.DamageTypeRepository
import io.vbytsyuk.dnd.data.damage.type.json.DamageTypeJsonParser
import io.vbytsyuk.dnd.data.equipment.category.EquipmentCategoriesLoadUseCaseImpl
import io.vbytsyuk.dnd.data.equipment.category.EquipmentCategoriesReader
import io.vbytsyuk.dnd.data.equipment.category.db.EquipmentCategoryDao
import io.vbytsyuk.dnd.data.equipment.category.db.EquipmentCategoryRepository
import io.vbytsyuk.dnd.data.equipment.category.json.EquipmentCategoryJsonParser
import io.vbytsyuk.dnd.data.language.LanguagesLoadUseCaseImpl
import io.vbytsyuk.dnd.data.language.LanguagesReader
import io.vbytsyuk.dnd.data.language.db.LanguageDao
import io.vbytsyuk.dnd.data.language.db.LanguageRepository
import io.vbytsyuk.dnd.data.language.json.LanguageJsonParser
import io.vbytsyuk.dnd.data.magic.school.MagicSchoolsLoadUseCaseImpl
import io.vbytsyuk.dnd.data.magic.school.MagicSchoolsReader
import io.vbytsyuk.dnd.data.magic.school.db.MagicSchoolDao
import io.vbytsyuk.dnd.data.magic.school.db.MagicSchoolRepository
import io.vbytsyuk.dnd.data.magic.school.json.MagicSchoolJsonParser
import io.vbytsyuk.dnd.data.rule.base.RulesLoadUseCaseImpl
import io.vbytsyuk.dnd.data.rule.base.RulesReader
import io.vbytsyuk.dnd.data.rule.base.db.RuleDao
import io.vbytsyuk.dnd.data.rule.base.db.RuleRepository
import io.vbytsyuk.dnd.data.rule.base.json.RuleJsonParser
import io.vbytsyuk.dnd.data.rule.section.RuleSectionsLoadUseCaseImpl
import io.vbytsyuk.dnd.data.rule.section.RuleSectionsReader
import io.vbytsyuk.dnd.data.rule.section.db.RuleSectionDao
import io.vbytsyuk.dnd.data.rule.section.db.RuleSectionRepository
import io.vbytsyuk.dnd.data.rule.section.json.RuleSectionJsonParser
import io.vbytsyuk.dnd.data.skill.SkillsLoadUseCaseImpl
import io.vbytsyuk.dnd.data.skill.SkillsReader
import io.vbytsyuk.dnd.data.skill.db.SkillDao
import io.vbytsyuk.dnd.data.skill.db.SkillRepository
import io.vbytsyuk.dnd.data.skill.json.SkillJsonParser
import io.vbytsyuk.dnd.data.weapon.property.WeaponPropertiesLoadUseCaseImpl
import io.vbytsyuk.dnd.data.weapon.property.WeaponPropertiesReader
import io.vbytsyuk.dnd.data.weapon.property.db.RoomWeaponPropertyDao
import io.vbytsyuk.dnd.data.weapon.property.db.WeaponPropertyDaoImpl
import io.vbytsyuk.dnd.data.weapon.property.json.WeaponPropertyJsonParser
import io.vbytsyuk.dnd.domain.usecases.LoadRulebookUseCase
import kotlinx.serialization.json.Json
import org.koin.dsl.module

fun readerModule() = module {
    includes(
        conditionReaderModule(),
        damageTypeReaderModule(),
        weaponPropertyReaderModule(),
        alignmentReaderModule(),
        magicSchoolReaderModule(),
        languageReaderModule(),
        ruleSectionModule(),
        ruleModule(),
        abilityScoreModule(),
        skillModule(),
        equipmentCategoryModule(),
    )
    factory<Json> { Json { ignoreUnknownKeys = true } }
    factory<LoadRulebookUseCase> {
        LoadRulebookUseCase(
            conditionLoadUseCase = get<ConditionsLoadUseCaseImpl>(),
            damageTypeLoadUseCase = get<DamageTypesLoadUseCaseImpl>(),
            weaponPropertyLoadUseCase = get<WeaponPropertiesLoadUseCaseImpl>(),
            alignmentsLoadUseCase = get<AlignmentsLoadUseCaseImpl>(),
            magicSchoolsLoadUseCase = get<MagicSchoolsLoadUseCaseImpl>(),
            languagesLoadUseCase = get<LanguagesLoadUseCaseImpl>(),
            abilityScoresLoadUseCase = get<AbilityScoresLoadUseCaseImpl>(),
            skillsLoadUseCase = get<SkillsLoadUseCaseImpl>(),
            equipmentCategoriesLoadUseCase = get<EquipmentCategoriesLoadUseCaseImpl>(),
            ruleSectionsLoadUseCase = get<RuleSectionsLoadUseCaseImpl>(),
            rulesLoadUseCase = get<RulesLoadUseCaseImpl>(),
        )
    }
}

fun conditionReaderModule() = module {
    factory { ConditionsLoadUseCaseImpl(reader = get(), repository = get()) }
    factory { ConditionsReader(jsonParser = get()) }
    factory { ConditionJsonParser(json = get()) }
    factory { ConditionRepository(conditionDao = get()) }
    factory<ConditionDao> { get<RulebookRoomDatabase>().getConditionDao() }
}

fun damageTypeReaderModule() = module {
    factory { DamageTypesLoadUseCaseImpl(reader = get(), repository = get()) }
    factory { DamageTypesReader(jsonParser = get()) }
    factory { DamageTypeJsonParser(json = get()) }
    factory { DamageTypeRepository(damageTypeDao = get()) }
    factory<DamageTypeDao> { get<RulebookRoomDatabase>().getDamageTypeDao() }
}

fun weaponPropertyReaderModule() = module {
    factory { WeaponPropertiesLoadUseCaseImpl(reader = get(), dao = get()) }
    factory { WeaponPropertiesReader(jsonParser = get()) }
    factory { WeaponPropertyJsonParser(json = get()) }
    factory { WeaponPropertyDaoImpl(roomWeaponPropertyDao = get()) }
    factory<RoomWeaponPropertyDao> { get<RulebookRoomDatabase>().getWeaponPropertyDao() }
}

fun alignmentReaderModule() = module {
    factory { AlignmentsLoadUseCaseImpl(reader = get(), repository = get()) }
    factory { AlignmentsReader(jsonParser = get()) }
    factory { AlignmentJsonParser(json = get()) }
    factory { AlignmentRepository(alignmentDao = get()) }
    factory<AlignmentDao> { get<RulebookRoomDatabase>().getAlignmentDao() }
}

fun magicSchoolReaderModule() = module {
    factory { MagicSchoolsLoadUseCaseImpl(reader = get(), repository = get()) }
    factory { MagicSchoolsReader(jsonParser = get()) }
    factory { MagicSchoolJsonParser(json = get()) }
    factory { MagicSchoolRepository(magicSchoolDao = get()) }
    factory<MagicSchoolDao> { get<RulebookRoomDatabase>().getMagicSchoolDao() }
}

fun languageReaderModule() = module {
    factory { LanguagesLoadUseCaseImpl(reader = get(), repository = get()) }
    factory { LanguagesReader(jsonParser = get()) }
    factory { LanguageJsonParser(json = get()) }
    factory { LanguageRepository(languageDao = get()) }
    factory<LanguageDao> { get<RulebookRoomDatabase>().getLanguageDao() }
}

fun ruleSectionModule() = module {
    factory { RuleSectionsLoadUseCaseImpl(reader = get(), repository = get()) }
    factory { RuleSectionsReader(jsonParser = get()) }
    factory { RuleSectionJsonParser(json = get()) }
    factory { RuleSectionRepository(ruleSectionDao = get()) }
    factory<RuleSectionDao> { get<RulebookRoomDatabase>().getRuleSectionDao() }
}

fun ruleModule() = module {
    factory { RulesLoadUseCaseImpl(reader = get(), repository = get()) }
    factory { RulesReader(jsonParser = get()) }
    factory { RuleJsonParser(json = get()) }
    factory { RuleRepository(ruleDao = get()) }
    factory<RuleDao> { get<RulebookRoomDatabase>().getRuleDao() }
}

fun abilityScoreModule() = module {
    factory { AbilityScoresLoadUseCaseImpl(reader = get(), repository = get()) }
    factory { AbilityScoresReader(jsonParser = get()) }
    factory { AbilityScoreJsonParser(json = get()) }
    factory { AbilityScoreRepository(abilityScoreDao = get()) }
    factory<AbilityScoreDao> { get<RulebookRoomDatabase>().getAbilityScoreDao() }
}

fun skillModule() = module {
    factory { SkillsLoadUseCaseImpl(reader = get(), repository = get()) }
    factory { SkillsReader(jsonParser = get()) }
    factory { SkillJsonParser(json = get()) }
    factory { SkillRepository(skillDao = get()) }
    factory<SkillDao> { get<RulebookRoomDatabase>().getSkillDao() }
}

fun equipmentCategoryModule() = module {
    factory { EquipmentCategoriesLoadUseCaseImpl(reader = get(), repository = get()) }
    factory { EquipmentCategoriesReader(jsonParser = get()) }
    factory { EquipmentCategoryJsonParser(json = get()) }
    factory { EquipmentCategoryRepository(equipmentCategoryDao = get()) }
    factory<EquipmentCategoryDao> { get<RulebookRoomDatabase>().getEquipmentCategoryDao() }
}
