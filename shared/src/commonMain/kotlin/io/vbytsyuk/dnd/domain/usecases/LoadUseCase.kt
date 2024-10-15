package io.vbytsyuk.dnd.domain.usecases

import io.vbytsyuk.dnd.domain.DndDao
import io.vbytsyuk.dnd.domain.Reader

open class LoadUseCase<Type>(
    private val reader: Reader<Type>,
    private val dao: DndDao<Type>,
) {

    suspend operator fun invoke(): List<Type> {
        val conditions = reader.read()
        if (dao.count() != 0) dao.clear()
        dao.insertAll(conditions)
        return conditions
    }
}