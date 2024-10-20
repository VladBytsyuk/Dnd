package io.vbytsyuk.dnd.data.language.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import kotlinx.coroutines.flow.Flow

@Dao
interface LanguageDao {
    @Insert
    suspend fun insert(item: LanguageEntity)

    @Insert
    suspend fun insertAll(items: List<LanguageEntity>)
    
    @Query("SELECT count(*) FROM LanguageEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM LanguageEntity WHERE id = :id")
    suspend fun getById(id: Id): LanguageEntity

    @Query("SELECT * FROM LanguageEntity")
    fun getAllAsFlow(): Flow<List<LanguageEntity>>

    @Query("DELETE FROM LanguageEntity")
    suspend fun clear()
}
