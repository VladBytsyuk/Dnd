package io.vbytsyuk.dnd.data.rule.section.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import kotlinx.coroutines.flow.Flow

@Dao
interface RuleSectionDao {
    @Insert
    suspend fun insert(item: RuleSectionEntity)

    @Insert
    suspend fun insertAll(items: List<RuleSectionEntity>)
    
    @Query("SELECT count(*) FROM RuleSectionEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM RuleSectionEntity WHERE id = :id")
    suspend fun getById(id: Id): RuleSectionEntity

    @Query("SELECT * FROM RuleSectionEntity")
    fun getAllAsFlow(): Flow<List<RuleSectionEntity>>

    @Query("DELETE FROM RuleSectionEntity")
    suspend fun clear()
}
