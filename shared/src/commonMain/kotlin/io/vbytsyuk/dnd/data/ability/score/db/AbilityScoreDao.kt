package io.vbytsyuk.dnd.data.ability.score.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import kotlinx.coroutines.flow.Flow

@Dao
interface AbilityScoreDao {
    @Insert
    suspend fun insert(item: AbilityScoreEntity)

    @Insert
    suspend fun insertAll(items: List<AbilityScoreEntity>)
    
    @Query("SELECT count(*) FROM AbilityScoreEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM AbilityScoreEntity WHERE id = :id")
    suspend fun getById(id: Id): AbilityScoreEntity

    @Query("SELECT * FROM AbilityScoreEntity")
    fun getAllAsFlow(): Flow<List<AbilityScoreEntity>>

    @Query("DELETE FROM AbilityScoreEntity")
    suspend fun clear()
}
