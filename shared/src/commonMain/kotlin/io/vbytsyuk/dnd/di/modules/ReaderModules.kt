package io.vbytsyuk.dnd.di.modules

import io.vbytsyuk.dnd.data.JsonParser
import io.vbytsyuk.dnd.data.RulebookRoomDatabase
import io.vbytsyuk.dnd.data.condition.ConditionDaoImpl
import io.vbytsyuk.dnd.data.condition.ConditionJson
import io.vbytsyuk.dnd.data.condition.ConditionJsonParser
import io.vbytsyuk.dnd.data.condition.ConditionReader
import io.vbytsyuk.dnd.data.condition.RoomConditionDao
import io.vbytsyuk.dnd.domain.condition.Condition
import io.vbytsyuk.dnd.domain.condition.ConditionDao
import io.vbytsyuk.dnd.domain.condition.Reader
import io.vbytsyuk.dnd.domain.usecases.ConditionLoadUseCase
import kotlinx.serialization.json.Json
import org.koin.dsl.module

fun readerModule() = module {
    includes(
        conditionReaderModule(),
    )
}

fun conditionReaderModule() = module {
    factory { ConditionLoadUseCase(conditionReader = get(), conditionDao = get()) }
    factory<Reader<Condition>> { ConditionReader(conditionJsonParser = get()) }
    factory<JsonParser<ConditionJson>> { ConditionJsonParser(json = get()) }
    factory<Json> { Json { ignoreUnknownKeys = true } }
    factory<ConditionDao> { ConditionDaoImpl(roomConditionDao = get()) }
    factory<RoomConditionDao> { get<RulebookRoomDatabase>().getConditionDao() }
}
