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
import io.vbytsyuk.dnd.data.rule.RulesLoadUseCaseImpl
import io.vbytsyuk.dnd.data.rule.RulesReader
import io.vbytsyuk.dnd.data.rule.db.RuleDao
import io.vbytsyuk.dnd.data.rule.db.RuleRepository
import io.vbytsyuk.dnd.data.rule.json.RuleJsonParser
import io.vbytsyuk.dnd.data.rule.section.RuleSectionsLoadUseCaseImpl
import io.vbytsyuk.dnd.data.rule.section.RuleSectionsReader
import io.vbytsyuk.dnd.data.rule.section.db.RuleSectionDao
import io.vbytsyuk.dnd.data.rule.section.db.RuleSectionRepository
import io.vbytsyuk.dnd.data.rule.section.json.RuleSectionJsonParser
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
            ruleSectionsLoadUseCase = get<RuleSectionsLoadUseCaseImpl>(),
            rulesLoadUseCase = get<RulesLoadUseCaseImpl>(),
        )
    }
}

fun conditionReaderModule() = module {
    factory<ConditionsLoadUseCaseImpl> { ConditionsLoadUseCaseImpl(reader = get(), repository = get()) }
    factory<ConditionsReader> { ConditionsReader(jsonParser = get()) }
    factory<ConditionJsonParser> { ConditionJsonParser(json = get()) }
    factory<ConditionRepository> { ConditionRepository(conditionDao = get()) }
    factory<ConditionDao> { get<RulebookRoomDatabase>().getConditionDao() }
}

fun damageTypeReaderModule() = module {
    factory<DamageTypesLoadUseCaseImpl> { DamageTypesLoadUseCaseImpl(reader = get(), repository = get()) }
    factory<DamageTypesReader> { DamageTypesReader(jsonParser = get()) }
    factory<DamageTypeJsonParser> { DamageTypeJsonParser(json = get()) }
    factory<DamageTypeRepository> { DamageTypeRepository(damageTypeDao = get()) }
    factory<DamageTypeDao> { get<RulebookRoomDatabase>().getDamageTypeDao() }
}

fun weaponPropertyReaderModule() = module {
    factory<WeaponPropertiesLoadUseCaseImpl> { WeaponPropertiesLoadUseCaseImpl(reader = get(), dao = get()) }
    factory<WeaponPropertiesReader> { WeaponPropertiesReader(jsonParser = get()) }
    factory<WeaponPropertyJsonParser> { WeaponPropertyJsonParser(json = get()) }
    factory<WeaponPropertyDaoImpl> { WeaponPropertyDaoImpl(roomWeaponPropertyDao = get()) }
    factory<RoomWeaponPropertyDao> { get<RulebookRoomDatabase>().getWeaponPropertyDao() }
}

fun alignmentReaderModule() = module {
    factory<AlignmentsLoadUseCaseImpl> { AlignmentsLoadUseCaseImpl(reader = get(), repository = get()) }
    factory<AlignmentsReader> { AlignmentsReader(jsonParser = get()) }
    factory<AlignmentJsonParser> { AlignmentJsonParser(json = get()) }
    factory<AlignmentRepository> { AlignmentRepository(alignmentDao = get()) }
    factory<AlignmentDao> { get<RulebookRoomDatabase>().getAlignmentDao() }
}

fun magicSchoolReaderModule() = module {
    factory<MagicSchoolsLoadUseCaseImpl> { MagicSchoolsLoadUseCaseImpl(reader = get(), repository = get()) }
    factory<MagicSchoolsReader> { MagicSchoolsReader(jsonParser = get()) }
    factory<MagicSchoolJsonParser> { MagicSchoolJsonParser(json = get()) }
    factory<MagicSchoolRepository> { MagicSchoolRepository(magicSchoolDao = get()) }
    factory<MagicSchoolDao> { get<RulebookRoomDatabase>().getMagicSchoolDao() }
}

fun languageReaderModule() = module {
    factory<LanguagesLoadUseCaseImpl> { LanguagesLoadUseCaseImpl(reader = get(), repository = get()) }
    factory<LanguagesReader> { LanguagesReader(jsonParser = get()) }
    factory<LanguageJsonParser> { LanguageJsonParser(json = get()) }
    factory<LanguageRepository> { LanguageRepository(languageDao = get()) }
    factory<LanguageDao> { get<RulebookRoomDatabase>().getLanguageDao() }
}

fun ruleSectionModule() = module {
    factory<RuleSectionsLoadUseCaseImpl> { RuleSectionsLoadUseCaseImpl(reader = get(), repository = get()) }
    factory<RuleSectionsReader> { RuleSectionsReader(jsonParser = get()) }
    factory<RuleSectionJsonParser> { RuleSectionJsonParser(json = get()) }
    factory<RuleSectionRepository> { RuleSectionRepository(ruleSectionDao = get()) }
    factory<RuleSectionDao> { get<RulebookRoomDatabase>().getRuleSectionDao() }
}

fun ruleModule() = module {
    factory<RulesLoadUseCaseImpl> { RulesLoadUseCaseImpl(reader = get(), repository = get()) }
    factory<RulesReader> { RulesReader(jsonParser = get()) }
    factory<RuleJsonParser> { RuleJsonParser(json = get()) }
    factory<RuleRepository> { RuleRepository(ruleDao = get(), ruleSectionRepository = get()) }
    factory<RuleDao> { get<RulebookRoomDatabase>().getRuleDao() }
}

fun abilityScoreModule() = module {
    factory<AbilityScoresLoadUseCaseImpl> { AbilityScoresLoadUseCaseImpl(reader = get(), repository = get()) }
    factory<AbilityScoresReader> { AbilityScoresReader(jsonParser = get()) }
    factory<AbilityScoreJsonParser> { AbilityScoreJsonParser(json = get()) }
    factory<AbilityScoreRepository> { AbilityScoreRepository(abilityScoreDao = get()) }
    factory<AbilityScoreDao> { get<RulebookRoomDatabase>().getAbilityScoreDao() }
}
