package io.vbytsyuk.dnd.data.rule.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.data.rule.section.db.RuleSectionDndDaoImpl
import io.vbytsyuk.dnd.domain.DndDao
import io.vbytsyuk.dnd.domain.rule.Rule
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Dao
interface RoomRuleDao {
    @Insert
    suspend fun insert(item: RuleEntity)

    @Insert
    suspend fun insertAll(items: List<RuleEntity>)
    
    @Query("SELECT count(*) FROM RuleEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM RuleEntity WHERE id = :id")
    suspend fun getById(id: Id): RuleEntity

    @Query("SELECT * FROM RuleEntity")
    fun getAllAsFlow(): Flow<List<RuleEntity>>

    @Query("DELETE FROM RuleEntity")
    suspend fun clear()
}

class RuleDndDaoImpl(
    private val roomRuleDao: RoomRuleDao,
    private val ruleSectionDndDaoImpl: RuleSectionDndDaoImpl,
) : DndDao<Rule> {

    override suspend fun insert(item: Rule) {
        roomRuleDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<Rule>) {
        roomRuleDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        roomRuleDao.count()

    override suspend fun getById(id: Id): Rule =
        roomRuleDao.getById(id).toDomain(::updateWithSubSections)

    override fun getAllAsFlow(): Flow<List<Rule>> =
        roomRuleDao.getAllAsFlow().map { it.toDomain(::updateWithSubSections) }

    override suspend fun clear() {
        roomRuleDao.clear()
    }

    private suspend fun updateWithSubSections(rule: Rule): Rule {
        val subSections = rule.subSections.map { ruleSection ->
            ruleSectionDndDaoImpl.getById(ruleSection.id)
        }
        return rule.copy(subSections = subSections)
    }
}
