package io.vbytsyuk.dnd.di.modules

import io.vbytsyuk.dnd.data.RulebookRoomDatabase
import io.vbytsyuk.dnd.data.alignment.AlignmentsLoadUseCaseImpl
import io.vbytsyuk.dnd.data.alignment.AlignmentsReader
import io.vbytsyuk.dnd.data.alignment.db.AlignmentDndDaoImpl
import io.vbytsyuk.dnd.data.alignment.db.RoomAlignmentDao
import io.vbytsyuk.dnd.data.alignment.json.AlignmentJsonParser
import io.vbytsyuk.dnd.data.condition.ConditionsLoadUseCaseImpl
import io.vbytsyuk.dnd.data.condition.ConditionsReader
import io.vbytsyuk.dnd.data.condition.db.ConditionDndDaoImpl
import io.vbytsyuk.dnd.data.condition.db.RoomConditionDao
import io.vbytsyuk.dnd.data.condition.json.ConditionJsonParser
import io.vbytsyuk.dnd.data.damage.type.DamageTypesLoadUseCaseImpl
import io.vbytsyuk.dnd.data.damage.type.DamageTypesReader
import io.vbytsyuk.dnd.data.damage.type.db.DamageTypeDaoImpl
import io.vbytsyuk.dnd.data.damage.type.db.RoomDamageTypeDao
import io.vbytsyuk.dnd.data.damage.type.json.DamageTypeJsonParser
import io.vbytsyuk.dnd.data.language.LanguagesLoadUseCaseImpl
import io.vbytsyuk.dnd.data.language.LanguagesReader
import io.vbytsyuk.dnd.data.language.db.LanguageDndDaoImpl
import io.vbytsyuk.dnd.data.language.db.RoomLanguageDao
import io.vbytsyuk.dnd.data.language.json.LanguageJsonParser
import io.vbytsyuk.dnd.data.magic.school.MagicSchoolsLoadUseCaseImpl
import io.vbytsyuk.dnd.data.magic.school.MagicSchoolsReader
import io.vbytsyuk.dnd.data.magic.school.db.MagicSchoolDndDaoImpl
import io.vbytsyuk.dnd.data.magic.school.db.RoomMagicSchoolDao
import io.vbytsyuk.dnd.data.magic.school.json.MagicSchoolJsonParser
import io.vbytsyuk.dnd.data.rule.section.RuleSectionsLoadUseCaseImpl
import io.vbytsyuk.dnd.data.rule.section.RuleSectionsReader
import io.vbytsyuk.dnd.data.rule.section.db.RoomRuleSectionDao
import io.vbytsyuk.dnd.data.rule.section.db.RuleSectionDndDaoImpl
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
    )
    factory<Json> { Json { ignoreUnknownKeys = true } }
    factory<LoadRulebookUseCase> {
        LoadRulebookUseCase(
            conditionLoadUseCase = get<ConditionsLoadUseCaseImpl>(),
            damageTypeLoadUseCase = get<DamageTypesLoadUseCaseImpl>(),
            weaponPropertyLoadUseCase = get<WeaponPropertiesLoadUseCaseImpl>(),
            alignmentsLoadUseCaseImpl = get<AlignmentsLoadUseCaseImpl>(),
            magicSchoolsLoadUseCaseImpl = get<MagicSchoolsLoadUseCaseImpl>(),
            languagesLoadUseCaseImpl = get<LanguagesLoadUseCaseImpl>(),
            ruleSectionsLoadUseCaseImpl = get<RuleSectionsLoadUseCaseImpl>(),
        )
    }
}

fun conditionReaderModule() = module {
    factory<ConditionsLoadUseCaseImpl> { ConditionsLoadUseCaseImpl(reader = get(), dao = get()) }
    factory<ConditionsReader> { ConditionsReader(jsonParser = get()) }
    factory<ConditionJsonParser> { ConditionJsonParser(json = get()) }
    factory<ConditionDndDaoImpl> { ConditionDndDaoImpl(roomConditionDao = get()) }
    factory<RoomConditionDao> { get<RulebookRoomDatabase>().getConditionDao() }
}

fun damageTypeReaderModule() = module {
    factory<DamageTypesLoadUseCaseImpl> { DamageTypesLoadUseCaseImpl(reader = get(), dao = get()) }
    factory<DamageTypesReader> { DamageTypesReader(jsonParser = get()) }
    factory<DamageTypeJsonParser> { DamageTypeJsonParser(json = get()) }
    factory<DamageTypeDaoImpl> { DamageTypeDaoImpl(roomDamageTypeDao = get()) }
    factory<RoomDamageTypeDao> { get<RulebookRoomDatabase>().getDamageTypeDao() }
}

fun weaponPropertyReaderModule() = module {
    factory<WeaponPropertiesLoadUseCaseImpl> { WeaponPropertiesLoadUseCaseImpl(reader = get(), dao = get()) }
    factory<WeaponPropertiesReader> { WeaponPropertiesReader(jsonParser = get()) }
    factory<WeaponPropertyJsonParser> { WeaponPropertyJsonParser(json = get()) }
    factory<WeaponPropertyDaoImpl> { WeaponPropertyDaoImpl(roomWeaponPropertyDao = get()) }
    factory<RoomWeaponPropertyDao> { get<RulebookRoomDatabase>().getWeaponPropertyDao() }
}

fun alignmentReaderModule() = module {
    factory<AlignmentsLoadUseCaseImpl> { AlignmentsLoadUseCaseImpl(reader = get(), dao = get()) }
    factory<AlignmentsReader> { AlignmentsReader(jsonParser = get()) }
    factory<AlignmentJsonParser> { AlignmentJsonParser(json = get()) }
    factory<AlignmentDndDaoImpl> { AlignmentDndDaoImpl(roomAlignmentDao = get()) }
    factory<RoomAlignmentDao> { get<RulebookRoomDatabase>().getAlignmentDao() }
}

fun magicSchoolReaderModule() = module {
    factory<MagicSchoolsLoadUseCaseImpl> { MagicSchoolsLoadUseCaseImpl(reader = get(), dao = get()) }
    factory<MagicSchoolsReader> { MagicSchoolsReader(jsonParser = get()) }
    factory<MagicSchoolJsonParser> { MagicSchoolJsonParser(json = get()) }
    factory<MagicSchoolDndDaoImpl> { MagicSchoolDndDaoImpl(roomMagicSchoolDao = get()) }
    factory<RoomMagicSchoolDao> { get<RulebookRoomDatabase>().getMagicSchoolDao() }
}

fun languageReaderModule() = module {
    factory<LanguagesLoadUseCaseImpl> { LanguagesLoadUseCaseImpl(reader = get(), dao = get()) }
    factory<LanguagesReader> { LanguagesReader(jsonParser = get()) }
    factory<LanguageJsonParser> { LanguageJsonParser(json = get()) }
    factory<LanguageDndDaoImpl> { LanguageDndDaoImpl(roomLanguageDao = get()) }
    factory<RoomLanguageDao> { get<RulebookRoomDatabase>().getLanguageDao() }
}

fun ruleSectionModule() = module {
    factory<RuleSectionsLoadUseCaseImpl> { RuleSectionsLoadUseCaseImpl(reader = get(), dao = get()) }
    factory<RuleSectionsReader> { RuleSectionsReader(jsonParser = get()) }
    factory<RuleSectionJsonParser> { RuleSectionJsonParser(json = get()) }
    factory<RuleSectionDndDaoImpl> { RuleSectionDndDaoImpl(roomRuleSectionDao = get()) }
    factory<RoomRuleSectionDao> { get<RulebookRoomDatabase>().getRuleSectionDao() }
}
