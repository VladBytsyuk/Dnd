package io.vbytsyuk.dnd.data.condition.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import kotlinx.coroutines.flow.Flow

@Dao
interface ConditionDao {
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
