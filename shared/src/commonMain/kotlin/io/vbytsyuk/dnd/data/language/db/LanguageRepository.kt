package io.vbytsyuk.dnd.data.language.db

import io.vbytsyuk.dnd.data.Id
import io.vbytsyuk.dnd.domain.DndRepository
import io.vbytsyuk.dnd.domain.language.Language
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LanguageRepository(
    private val languageDao: LanguageDao,
) : DndRepository<Language> {

    override suspend fun insert(item: Language) {
        languageDao.insert(item.toEntity())
    }

    override suspend fun insertAll(items: List<Language>) {
        languageDao.insertAll(items.toEntity())
    }

    override suspend fun count(): Int =
        languageDao.count()

    override suspend fun getById(id: Id): Language =
        languageDao.getById(id).toDomain()

    override fun getAllAsFlow(): Flow<List<Language>> =
        languageDao.getAllAsFlow().map { it.toDomain() }

    override suspend fun clear() {
        languageDao.clear()
    }
}
