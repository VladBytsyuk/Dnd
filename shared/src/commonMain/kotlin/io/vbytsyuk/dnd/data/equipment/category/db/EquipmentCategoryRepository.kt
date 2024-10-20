package io.vbytsyuk.dnd.data.equipment.category.db

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.DndRepository
import io.vbytsyuk.dnd.domain.equipment.category.EquipmentCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EquipmentCategoryRepository(
    private val equipmentCategoryDao: EquipmentCategoryDao,
) : DndRepository<EquipmentCategory> {

    override suspend fun insert(item: EquipmentCategory) {
        equipmentCategoryDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<EquipmentCategory>) {
        equipmentCategoryDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        equipmentCategoryDao.count()

    override suspend fun getById(id: Id): EquipmentCategory =
        equipmentCategoryDao.getById(id).toDomain()

    override fun getAllAsFlow(): Flow<List<EquipmentCategory>> =
        equipmentCategoryDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        equipmentCategoryDao.clear()
    }
}
