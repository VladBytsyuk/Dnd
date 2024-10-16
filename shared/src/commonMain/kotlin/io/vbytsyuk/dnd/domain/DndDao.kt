package io.vbytsyuk.dnd.domain

import io.vbytsyuk.dnd.data.Id
import kotlinx.coroutines.flow.Flow

interface DndDao<Type> {
    suspend fun insert(item: Type)
    suspend fun insertAll(items: List<Type>)
    suspend fun count(): Int
    suspend fun getById(id: Id): Type
    fun getAllAsFlow(): Flow<List<Type>>
    suspend fun clear()
}
