package io.vbytsyuk.dnd.data.rule.section.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.domain.DndDao
import io.vbytsyuk.dnd.domain.rule.section.RuleSection
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Dao
interface RoomRuleSectionDao {
    @Insert
    suspend fun insert(item: RuleSectionEntity)

    @Insert
    suspend fun insertAll(items: List<RuleSectionEntity>)
    
    @Query("SELECT count(*) FROM RuleSectionEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM RuleSectionEntity")
    fun getAllAsFlow(): Flow<List<RuleSectionEntity>>

    @Query("DELETE FROM RuleSectionEntity")
    suspend fun clear()
}

class RuleSectionDndDaoImpl(
    private val roomRuleSectionDao: RoomRuleSectionDao,
) : DndDao<RuleSection> {

    override suspend fun insert(item: RuleSection) {
        roomRuleSectionDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<RuleSection>) {
        roomRuleSectionDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        roomRuleSectionDao.count()

    override fun getAllAsFlow(): Flow<List<RuleSection>> =
        roomRuleSectionDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        roomRuleSectionDao.clear()
    }
}
