package io.vbytsyuk.dnd.di.modules

import io.vbytsyuk.dnd.data.RulebookRoomDatabase
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
    )
    factory<Json> { Json { ignoreUnknownKeys = true } }
    factory<LoadRulebookUseCase> {
        LoadRulebookUseCase(
            conditionLoadUseCase = get<ConditionsLoadUseCaseImpl>(),
            damageTypeLoadUseCase = get<DamageTypesLoadUseCaseImpl>(),
            weaponPropertyLoadUseCase = get<WeaponPropertiesLoadUseCaseImpl>(),
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
