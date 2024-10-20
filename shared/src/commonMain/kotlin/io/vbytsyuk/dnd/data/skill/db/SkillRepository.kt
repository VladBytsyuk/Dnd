package io.vbytsyuk.dnd.data.skill.db

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.data.ability.score.db.AbilityScoreRepository
import io.vbytsyuk.dnd.domain.DndRepository
import io.vbytsyuk.dnd.domain.skill.Skill
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SkillRepository(
    private val skillDao: SkillDao,
    private val abilityScoreRepository: AbilityScoreRepository,
) : DndRepository<Skill> {

    override suspend fun insert(item: Skill) {
        skillDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<Skill>) {
        skillDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        skillDao.count()

    override suspend fun getById(id: Id): Skill =
        skillDao.getById(id).toDomain(::updateWithSubSections)

    override fun getAllAsFlow(): Flow<List<Skill>> =
        skillDao.getAllAsFlow().map { it.toDomain(::updateWithSubSections) }

    override suspend fun clear() {
        skillDao.clear()
    }

    private suspend fun updateWithSubSections(skill: Skill): Skill {
        val abilityScore = abilityScoreRepository.getById(skill.abilityScore.id)
        return skill.copy(abilityScore = abilityScore)
    }
}
