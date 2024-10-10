package io.vbytsyuk.dnd.db.condition

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ConditionDao {
    @Insert
    suspend fun insert(item: ConditionEntity)
    
    @Query("SELECT count(*) FROM ConditionEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM ConditionEntity")
    fun getAllAsFlow(): Flow<List<ConditionEntity>>
}
