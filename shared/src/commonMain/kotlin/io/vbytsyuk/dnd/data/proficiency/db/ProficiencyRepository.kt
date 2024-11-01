package io.vbytsyuk.dnd.data.proficiency.db

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.DndRepository
import io.vbytsyuk.dnd.domain.proficiency.Proficiency
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProficiencyRepository(
    private val proficiencyDao: ProficiencyDao,
) : DndRepository<Proficiency> {

    override suspend fun insert(item: Proficiency) {
        proficiencyDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<Proficiency>) {
        proficiencyDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        proficiencyDao.count()

    override suspend fun getById(id: Id): Proficiency =
        proficiencyDao.getById(id).toDomain()

    override fun getAllAsFlow(): Flow<List<Proficiency>> =
        proficiencyDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        proficiencyDao.clear()
    }
}
