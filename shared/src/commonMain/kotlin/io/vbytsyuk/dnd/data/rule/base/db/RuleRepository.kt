package io.vbytsyuk.dnd.data.rule.base.db

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.DndRepository
import io.vbytsyuk.dnd.domain.rule.base.Rule
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RuleRepository(
    private val ruleDao: RuleDao,
) : DndRepository<Rule> {

    override suspend fun insert(item: Rule) {
        ruleDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<Rule>) {
        ruleDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        ruleDao.count()

    override suspend fun getById(id: Id): Rule =
        ruleDao.getById(id).toDomain()

    override fun getAllAsFlow(): Flow<List<Rule>> =
        ruleDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        ruleDao.clear()
    }
}
