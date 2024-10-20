package io.vbytsyuk.dnd.data.damage.type.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import kotlinx.coroutines.flow.Flow

@Dao
interface DamageTypeDao {
    @Insert
    suspend fun insert(item: DamageTypeEntity)

    @Insert
    suspend fun insertAll(items: List<DamageTypeEntity>)
    
    @Query("SELECT count(*) FROM DamageTypeEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM DamageTypeEntity WHERE id = :id")
    suspend fun getById(id: Id): DamageTypeEntity

    @Query("SELECT * FROM DamageTypeEntity")
    fun getAllAsFlow(): Flow<List<DamageTypeEntity>>

    @Query("DELETE FROM DamageTypeEntity")
    suspend fun clear()
}
