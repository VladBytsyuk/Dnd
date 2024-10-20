package io.vbytsyuk.dnd.data.alignment.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import kotlinx.coroutines.flow.Flow

@Dao
interface AlignmentDao {
    @Insert
    suspend fun insert(item: AlignmentEntity)

    @Insert
    suspend fun insertAll(items: List<AlignmentEntity>)
    
    @Query("SELECT count(*) FROM AlignmentEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM AlignmentEntity WHERE id = :id")
    suspend fun getById(id: Id): AlignmentEntity

    @Query("SELECT * FROM AlignmentEntity")
    fun getAllAsFlow(): Flow<List<AlignmentEntity>>

    @Query("DELETE FROM AlignmentEntity")
    suspend fun clear()
}
