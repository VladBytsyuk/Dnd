package io.vbytsyuk.dnd.data.condition.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.DndDao
import io.vbytsyuk.dnd.domain.condition.Condition
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Dao
interface RoomConditionDao {
    @Insert
    suspend fun insert(item: ConditionEntity)

    @Insert
    suspend fun insertAll(items: List<ConditionEntity>)
    
    @Query("SELECT count(*) FROM ConditionEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM ConditionEntity WHERE id = :id")
    suspend fun getById(id: Id): ConditionEntity

    @Query("SELECT * FROM ConditionEntity")
    fun getAllAsFlow(): Flow<List<ConditionEntity>>

    @Query("DELETE FROM ConditionEntity")
    suspend fun clear()
}

class ConditionDndDaoImpl(
    private val roomConditionDao: RoomConditionDao,
) : DndDao<Condition> {

    override suspend fun insert(item: Condition) {
        roomConditionDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<Condition>) {
        roomConditionDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        roomConditionDao.count()

    override suspend fun getById(id: Id): Condition =
        roomConditionDao.getById(id).toDomain()

    override fun getAllAsFlow(): Flow<List<Condition>> =
        roomConditionDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        roomConditionDao.clear()
    }
}
