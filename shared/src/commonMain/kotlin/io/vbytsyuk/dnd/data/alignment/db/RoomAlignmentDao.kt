package io.vbytsyuk.dnd.data.alignment.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.domain.DndDao
import io.vbytsyuk.dnd.domain.alignment.Alignment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Dao
interface RoomAlignmentDao {
    @Insert
    suspend fun insert(item: AlignmentEntity)

    @Insert
    suspend fun insertAll(items: List<AlignmentEntity>)
    
    @Query("SELECT count(*) FROM AlignmentEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM AlignmentEntity")
    fun getAllAsFlow(): Flow<List<AlignmentEntity>>

    @Query("DELETE FROM AlignmentEntity")
    suspend fun clear()
}

class AlignmentDndDaoImpl(
    private val roomAlignmentDao: RoomAlignmentDao,
) : DndDao<Alignment> {

    override suspend fun insert(item: Alignment) {
        roomAlignmentDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<Alignment>) {
        roomAlignmentDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        roomAlignmentDao.count()

    override fun getAllAsFlow(): Flow<List<Alignment>> =
        roomAlignmentDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        roomAlignmentDao.clear()
    }
}
