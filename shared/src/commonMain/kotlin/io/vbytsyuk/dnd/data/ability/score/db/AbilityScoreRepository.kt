package io.vbytsyuk.dnd.data.ability.score.db

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.DndRepository
import io.vbytsyuk.dnd.domain.ability.score.AbilityScore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AbilityScoreRepository(
    private val abilityScoreDao: AbilityScoreDao,
) : DndRepository<AbilityScore> {

    override suspend fun insert(item: AbilityScore) {
        abilityScoreDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<AbilityScore>) {
        abilityScoreDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        abilityScoreDao.count()

    override suspend fun getById(id: Id): AbilityScore =
        abilityScoreDao.getById(id).toDomain()

    override fun getAllAsFlow(): Flow<List<AbilityScore>> =
        abilityScoreDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        abilityScoreDao.clear()
    }
}
