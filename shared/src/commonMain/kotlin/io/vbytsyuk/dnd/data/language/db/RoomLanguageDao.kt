package io.vbytsyuk.dnd.data.language.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.DndDao
import io.vbytsyuk.dnd.domain.language.Language
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Dao
interface RoomLanguageDao {
    @Insert
    suspend fun insert(item: LanguageEntity)

    @Insert
    suspend fun insertAll(items: List<LanguageEntity>)
    
    @Query("SELECT count(*) FROM LanguageEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM LanguageEntity WHERE id = :id")
    suspend fun getById(id: Id): LanguageEntity

    @Query("SELECT * FROM LanguageEntity")
    fun getAllAsFlow(): Flow<List<LanguageEntity>>

    @Query("DELETE FROM LanguageEntity")
    suspend fun clear()
}

class LanguageDndDaoImpl(
    private val roomLanguageDao: RoomLanguageDao,
) : DndDao<Language> {

    override suspend fun insert(item: Language) {
        roomLanguageDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<Language>) {
        roomLanguageDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        roomLanguageDao.count()

    override suspend fun getById(id: Id): Language =
        roomLanguageDao.getById(id).toDomain()

    override fun getAllAsFlow(): Flow<List<Language>> =
        roomLanguageDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        roomLanguageDao.clear()
    }
}
