package io.vbytsyuk.dnd.di.modules

import io.vbytsyuk.dnd.data.RulebookRoomDatabase
import io.vbytsyuk.dnd.data.condition.ConditionLoadUseCaseImpl
import io.vbytsyuk.dnd.data.condition.ConditionReader
import io.vbytsyuk.dnd.data.condition.db.ConditionDndDaoImpl
import io.vbytsyuk.dnd.data.condition.db.RoomConditionDao
import io.vbytsyuk.dnd.data.condition.json.ConditionJsonParser
import io.vbytsyuk.dnd.data.damage.type.DamageReader
import io.vbytsyuk.dnd.data.damage.type.DamageTypeLoadUseCaseImpl
import io.vbytsyuk.dnd.data.damage.type.db.DamageTypeDaoImpl
import io.vbytsyuk.dnd.data.damage.type.db.RoomDamageTypeDao
import io.vbytsyuk.dnd.data.damage.type.json.DamageTypeJsonParser
import io.vbytsyuk.dnd.domain.usecases.LoadRulebookUseCase
import kotlinx.serialization.json.Json
import org.koin.dsl.module

fun readerModule() = module {
    includes(
        conditionReaderModule(),
        damageTypeReaderModule(),
    )
    factory<Json> { Json { ignoreUnknownKeys = true } }
    factory<LoadRulebookUseCase> {
        LoadRulebookUseCase(
            conditionLoadUseCase = get<ConditionLoadUseCaseImpl>(),
            damageTypeLoadUseCase = get<DamageTypeLoadUseCaseImpl>(),
        )
    }
}

fun conditionReaderModule() = module {
    factory<ConditionLoadUseCaseImpl> { ConditionLoadUseCaseImpl(reader = get(), dao = get()) }
    factory<ConditionReader> { ConditionReader(jsonParser = get()) }
    factory<ConditionJsonParser> { ConditionJsonParser(json = get()) }
    factory<ConditionDndDaoImpl> { ConditionDndDaoImpl(roomConditionDao = get()) }
    factory<RoomConditionDao> { get<RulebookRoomDatabase>().getConditionDao() }
}

fun damageTypeReaderModule() = module {
    factory<DamageTypeLoadUseCaseImpl> { DamageTypeLoadUseCaseImpl(reader = get(), dao = get()) }
    factory<DamageReader> { DamageReader(jsonParser = get()) }
    factory<DamageTypeJsonParser> { DamageTypeJsonParser(json = get()) }
    factory<DamageTypeDaoImpl> { DamageTypeDaoImpl(roomDamageTypeDao = get()) }
    factory<RoomDamageTypeDao> { get<RulebookRoomDatabase>().getDamageTypeDao() }
}
