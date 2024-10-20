package io.vbytsyuk.dnd.data.magic.school.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import kotlinx.coroutines.flow.Flow

@Dao
interface MagicSchoolDao {
    @Insert
    suspend fun insert(item: MagicSchoolEntity)

    @Insert
    suspend fun insertAll(items: List<MagicSchoolEntity>)
    
    @Query("SELECT count(*) FROM MagicSchoolEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM MagicSchoolEntity WHERE id = :id")
    suspend fun getById(id: Id): MagicSchoolEntity

    @Query("SELECT * FROM MagicSchoolEntity")
    fun getAllAsFlow(): Flow<List<MagicSchoolEntity>>

    @Query("DELETE FROM MagicSchoolEntity")
    suspend fun clear()
}
