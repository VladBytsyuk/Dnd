package io.vbytsyuk.dnd.data.magic.school.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.domain.DndDao
import io.vbytsyuk.dnd.domain.magic.school.MagicSchool
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Dao
interface RoomMagicSchoolDao {
    @Insert
    suspend fun insert(item: MagicSchoolEntity)

    @Insert
    suspend fun insertAll(items: List<MagicSchoolEntity>)
    
    @Query("SELECT count(*) FROM MagicSchoolEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM MagicSchoolEntity")
    fun getAllAsFlow(): Flow<List<MagicSchoolEntity>>

    @Query("DELETE FROM MagicSchoolEntity")
    suspend fun clear()
}

class MagicSchoolDndDaoImpl(
    private val roomMagicSchoolDao: RoomMagicSchoolDao,
) : DndDao<MagicSchool> {

    override suspend fun insert(item: MagicSchool) {
        roomMagicSchoolDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<MagicSchool>) {
        roomMagicSchoolDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        roomMagicSchoolDao.count()

    override fun getAllAsFlow(): Flow<List<MagicSchool>> =
        roomMagicSchoolDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        roomMagicSchoolDao.clear()
    }
}
