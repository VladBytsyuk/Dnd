package io.vbytsyuk.dnd.data.equipment.base.db

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.DndRepository
import io.vbytsyuk.dnd.domain.equipment.base.Equipment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EquipmentRepository(
    private val equipmentDao: EquipmentDao,
) : DndRepository<Equipment> {

    override suspend fun insert(item: Equipment) {
        equipmentDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<Equipment>) {
        equipmentDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        equipmentDao.count()

    override suspend fun getById(id: Id): Equipment =
        equipmentDao.getById(id).toDomain()

    override fun getAllAsFlow(): Flow<List<Equipment>> =
        equipmentDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        equipmentDao.clear()
    }
}
