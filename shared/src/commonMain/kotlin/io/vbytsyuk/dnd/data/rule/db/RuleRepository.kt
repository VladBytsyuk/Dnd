package io.vbytsyuk.dnd.data.rule.db

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.data.rule.section.db.RuleSectionRepository
import io.vbytsyuk.dnd.domain.DndRepository
import io.vbytsyuk.dnd.domain.rule.Rule
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RuleRepository(
    private val ruleDao: RuleDao,
    private val ruleSectionRepository: RuleSectionRepository,
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
        ruleDao.getById(id).toDomain(::updateWithSubSections)

    override fun getAllAsFlow(): Flow<List<Rule>> =
        ruleDao.getAllAsFlow().map { it.toDomain(::updateWithSubSections) }

    override suspend fun clear() {
        ruleDao.clear()
    }

    private suspend fun updateWithSubSections(rule: Rule): Rule {
        val subSections = rule.subSections.map { ruleSection ->
            ruleSectionRepository.getById(ruleSection.id)
        }
        return rule.copy(subSections = subSections)
    }
}
