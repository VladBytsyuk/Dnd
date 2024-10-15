package io.vbytsyuk.dnd.domain.condition

import kotlinx.coroutines.flow.Flow

interface ConditionDao {
    suspend fun insert(item: Condition)
    suspend fun insertAll(items: List<Condition>)
    suspend fun count(): Int
    fun getAllAsFlow(): Flow<List<Condition>>
    suspend fun clear()
}
