package io.vbytsyuk.dnd.data.ability.score.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.DndDao
import io.vbytsyuk.dnd.domain.ability.score.AbilityScore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Dao
interface RoomAbilityScoreDao {
    @Insert
    suspend fun insert(item: AbilityScoreEntity)

    @Insert
    suspend fun insertAll(items: List<AbilityScoreEntity>)
    
    @Query("SELECT count(*) FROM AbilityScoreEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM AbilityScoreEntity WHERE id = :id")
    suspend fun getById(id: Id): AbilityScoreEntity

    @Query("SELECT * FROM AbilityScoreEntity")
    fun getAllAsFlow(): Flow<List<AbilityScoreEntity>>

    @Query("DELETE FROM AbilityScoreEntity")
    suspend fun clear()
}

class AbilityScoreDndDaoImpl(
    private val roomAbilityScoreDao: RoomAbilityScoreDao,
) : DndDao<AbilityScore> {

    override suspend fun insert(item: AbilityScore) {
        roomAbilityScoreDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<AbilityScore>) {
        roomAbilityScoreDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        roomAbilityScoreDao.count()

    override suspend fun getById(id: Id): AbilityScore =
        roomAbilityScoreDao.getById(id).toDomain()

    override fun getAllAsFlow(): Flow<List<AbilityScore>> =
        roomAbilityScoreDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        roomAbilityScoreDao.clear()
    }
}
