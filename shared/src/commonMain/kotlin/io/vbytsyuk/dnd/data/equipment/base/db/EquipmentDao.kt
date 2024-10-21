package io.vbytsyuk.dnd.data.equipment.base.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import kotlinx.coroutines.flow.Flow

@Dao
interface EquipmentDao {
    @Insert
    suspend fun insert(item: EquipmentEntity)

    @Insert
    suspend fun insertAll(items: List<EquipmentEntity>)
    
    @Query("SELECT count(*) FROM EquipmentEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM EquipmentEntity WHERE id = :id")
    suspend fun getById(id: Id): EquipmentEntity

    @Query("SELECT * FROM EquipmentEntity")
    fun getAllAsFlow(): Flow<List<EquipmentEntity>>

    @Query("DELETE FROM EquipmentEntity")
    suspend fun clear()
}
