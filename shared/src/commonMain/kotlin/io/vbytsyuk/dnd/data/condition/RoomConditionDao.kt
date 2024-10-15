package io.vbytsyuk.dnd.data.condition

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.domain.condition.Condition
import io.vbytsyuk.dnd.domain.condition.ConditionDao
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

    @Query("SELECT * FROM ConditionEntity")
    fun getAllAsFlow(): Flow<List<ConditionEntity>>
}

class ConditionDaoImpl(
    private val roomConditionDao: RoomConditionDao,
) : ConditionDao {

    override suspend fun insert(item: Condition) {
        roomConditionDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<Condition>) {
        roomConditionDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        roomConditionDao.count()

    override fun getAllAsFlow(): Flow<List<Condition>> =
        roomConditionDao.getAllAsFlow().map { it.toDomain() }
}