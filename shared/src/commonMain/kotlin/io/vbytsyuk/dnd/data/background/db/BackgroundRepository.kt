package io.vbytsyuk.dnd.data.background.db

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.DndRepository
import io.vbytsyuk.dnd.domain.background.Background
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BackgroundRepository(
    private val backgroundDao: BackgroundDao,
) : DndRepository<Background> {

    override suspend fun insert(item: Background) {
        backgroundDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<Background>) {
        backgroundDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        backgroundDao.count()

    override suspend fun getById(id: Id): Background =
        backgroundDao.getById(id).toDomain()

    override fun getAllAsFlow(): Flow<List<Background>> =
        backgroundDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        backgroundDao.clear()
    }
}
