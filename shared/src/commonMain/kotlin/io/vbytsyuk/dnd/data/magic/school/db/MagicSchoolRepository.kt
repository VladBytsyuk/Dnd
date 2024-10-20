package io.vbytsyuk.dnd.data.magic.school.db

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.DndRepository
import io.vbytsyuk.dnd.domain.magic.school.MagicSchool
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MagicSchoolRepository(
    private val magicSchoolDao: MagicSchoolDao,
) : DndRepository<MagicSchool> {

    override suspend fun insert(item: MagicSchool) {
        magicSchoolDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<MagicSchool>) {
        magicSchoolDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        magicSchoolDao.count()

    override suspend fun getById(id: Id): MagicSchool =
        magicSchoolDao.getById(id).toDomain()

    override fun getAllAsFlow(): Flow<List<MagicSchool>> =
        magicSchoolDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        magicSchoolDao.clear()
    }
}
