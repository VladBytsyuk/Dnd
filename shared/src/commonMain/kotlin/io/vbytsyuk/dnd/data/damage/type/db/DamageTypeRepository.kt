package io.vbytsyuk.dnd.data.damage.type.db

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.DndRepository
import io.vbytsyuk.dnd.domain.damage.type.DamageType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DamageTypeRepository(
    private val damageTypeDao: DamageTypeDao,
) : DndRepository<DamageType> {

    override suspend fun insert(item: DamageType) {
        damageTypeDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<DamageType>) {
        damageTypeDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        damageTypeDao.count()

    override suspend fun getById(id: Id): DamageType =
        damageTypeDao.getById(id).toDomain()

    override fun getAllAsFlow(): Flow<List<DamageType>> =
        damageTypeDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        damageTypeDao.clear()
    }
}
