package io.vbytsyuk.dnd.data.rule.section.db

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.DndRepository
import io.vbytsyuk.dnd.domain.rule.section.RuleSection
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RuleSectionRepository(
    private val ruleSectionDao: RuleSectionDao,
) : DndRepository<RuleSection> {

    override suspend fun insert(item: RuleSection) {
        ruleSectionDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<RuleSection>) {
        ruleSectionDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        ruleSectionDao.count()

    override suspend fun getById(id: Id): RuleSection =
        ruleSectionDao.getById(id).toDomain()

    override fun getAllAsFlow(): Flow<List<RuleSection>> =
        ruleSectionDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        ruleSectionDao.clear()
    }
}
