package io.vbytsyuk.dnd.data.skill.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import kotlinx.coroutines.flow.Flow

@Dao
interface SkillDao {
    @Insert
    suspend fun insert(item: SkillEntity)

    @Insert
    suspend fun insertAll(items: List<SkillEntity>)
    
    @Query("SELECT count(*) FROM SkillEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM SkillEntity WHERE id = :id")
    suspend fun getById(id: Id): SkillEntity

    @Query("SELECT * FROM SkillEntity")
    fun getAllAsFlow(): Flow<List<SkillEntity>>

    @Query("DELETE FROM SkillEntity")
    suspend fun clear()
}
