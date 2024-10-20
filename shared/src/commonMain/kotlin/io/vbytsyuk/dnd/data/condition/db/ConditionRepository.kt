package io.vbytsyuk.dnd.data.condition.db

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.DndRepository
import io.vbytsyuk.dnd.domain.condition.Condition
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ConditionRepository(
    private val conditionDao: ConditionDao,
) : DndRepository<Condition> {

    override suspend fun insert(item: Condition) {
        conditionDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<Condition>) {
        conditionDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        conditionDao.count()

    override suspend fun getById(id: Id): Condition =
        conditionDao.getById(id).toDomain()

    override fun getAllAsFlow(): Flow<List<Condition>> =
        conditionDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        conditionDao.clear()
    }
}
