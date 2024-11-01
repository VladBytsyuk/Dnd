package io.vbytsyuk.dnd.data.proficiency.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import kotlinx.coroutines.flow.Flow

@Dao
interface ProficiencyDao {
    @Insert
    suspend fun insert(item: ProficiencyEntity)

    @Insert
    suspend fun insertAll(items: List<ProficiencyEntity>)
    
    @Query("SELECT count(*) FROM ProficiencyEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM ProficiencyEntity WHERE id = :id")
    suspend fun getById(id: Id): ProficiencyEntity

    @Query("SELECT * FROM ProficiencyEntity")
    fun getAllAsFlow(): Flow<List<ProficiencyEntity>>

    @Query("DELETE FROM ProficiencyEntity")
    suspend fun clear()
}
