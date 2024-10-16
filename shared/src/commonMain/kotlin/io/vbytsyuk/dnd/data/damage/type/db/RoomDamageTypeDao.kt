package io.vbytsyuk.dnd.data.damage.type.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.DndDao
import io.vbytsyuk.dnd.domain.damage.type.DamageType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Dao
interface RoomDamageTypeDao {
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

class DamageTypeDaoImpl(
    private val roomDamageTypeDao: RoomDamageTypeDao,
) : DndDao<DamageType> {

    override suspend fun insert(item: DamageType) {
        roomDamageTypeDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<DamageType>) {
        roomDamageTypeDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        roomDamageTypeDao.count()

    override suspend fun getById(id: Id): DamageType =
        roomDamageTypeDao.getById(id).toDomain()

    override fun getAllAsFlow(): Flow<List<DamageType>> =
        roomDamageTypeDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        roomDamageTypeDao.clear()
    }
}
