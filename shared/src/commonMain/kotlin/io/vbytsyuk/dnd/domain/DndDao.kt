package io.vbytsyuk.dnd.domain

import kotlinx.coroutines.flow.Flow

interface DndDao<Type> {
    suspend fun insert(item: Type)
    suspend fun insertAll(items: List<Type>)
    suspend fun count(): Int
    fun getAllAsFlow(): Flow<List<Type>>
    suspend fun clear()
}
