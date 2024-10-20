package io.vbytsyuk.dnd.data.rule.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import kotlinx.coroutines.flow.Flow

@Dao
interface RuleDao {
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
