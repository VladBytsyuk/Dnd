package io.vbytsyuk.dnd.data.background.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import kotlinx.coroutines.flow.Flow

@Dao
interface BackgroundDao {
    @Insert
    suspend fun insert(item: BackgroundEntity)

    @Insert
    suspend fun insertAll(items: List<BackgroundEntity>)
    
    @Query("SELECT count(*) FROM BackgroundEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM BackgroundEntity WHERE id = :id")
    suspend fun getById(id: Id): BackgroundEntity

    @Query("SELECT * FROM BackgroundEntity")
    fun getAllAsFlow(): Flow<List<BackgroundEntity>>

    @Query("DELETE FROM BackgroundEntity")
    suspend fun clear()
}
