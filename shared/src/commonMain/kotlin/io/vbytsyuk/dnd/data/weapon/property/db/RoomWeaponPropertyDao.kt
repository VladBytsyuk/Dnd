package io.vbytsyuk.dnd.data.weapon.property.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.domain.DndDao
import io.vbytsyuk.dnd.domain.weapon.property.WeaponProperty
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Dao
interface RoomWeaponPropertyDao {
    @Insert
    suspend fun insert(item: WeaponPropertyEntity)

    @Insert
    suspend fun insertAll(items: List<WeaponPropertyEntity>)

    @Query("SELECT count(*) FROM WeaponPropertyEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM WeaponPropertyEntity")
    fun getAllAsFlow(): Flow<List<WeaponPropertyEntity>>

    @Query("DELETE FROM WeaponPropertyEntity")
    suspend fun clear()
}

class WeaponPropertyDaoImpl(
    private val roomWeaponPropertyDao: RoomWeaponPropertyDao,
) : DndDao<WeaponProperty> {

    override suspend fun insert(item: WeaponProperty) {
        roomWeaponPropertyDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<WeaponProperty>) {
        roomWeaponPropertyDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        roomWeaponPropertyDao.count()

    override fun getAllAsFlow(): Flow<List<WeaponProperty>> =
        roomWeaponPropertyDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        roomWeaponPropertyDao.clear()
    }
}
