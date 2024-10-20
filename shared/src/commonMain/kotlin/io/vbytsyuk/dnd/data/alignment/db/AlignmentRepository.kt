package io.vbytsyuk.dnd.data.alignment.db

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.DndRepository
import io.vbytsyuk.dnd.domain.alignment.Alignment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AlignmentRepository(
    private val alignmentDao: AlignmentDao,
) : DndRepository<Alignment> {

    override suspend fun insert(item: Alignment) {
        alignmentDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<Alignment>) {
        alignmentDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        alignmentDao.count()

    override suspend fun getById(id: Id): Alignment =
        alignmentDao.getById(id).toDomain()

    override fun getAllAsFlow(): Flow<List<Alignment>> =
        alignmentDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        alignmentDao.clear()
    }
}
