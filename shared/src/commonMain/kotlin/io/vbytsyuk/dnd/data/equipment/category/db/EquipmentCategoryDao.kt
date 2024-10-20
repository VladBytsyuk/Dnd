package io.vbytsyuk.dnd.data.equipment.category.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import kotlinx.coroutines.flow.Flow

@Dao
interface EquipmentCategoryDao {
    @Insert
    suspend fun insert(item: EquipmentCategoryEntity)

    @Insert
    suspend fun insertAll(items: List<EquipmentCategoryEntity>)
    
    @Query("SELECT count(*) FROM EquipmentCategoryEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM EquipmentCategoryEntity WHERE id = :id")
    suspend fun getById(id: Id): EquipmentCategoryEntity

    @Query("SELECT * FROM EquipmentCategoryEntity")
    fun getAllAsFlow(): Flow<List<EquipmentCategoryEntity>>

    @Query("DELETE FROM EquipmentCategoryEntity")
    suspend fun clear()
}
