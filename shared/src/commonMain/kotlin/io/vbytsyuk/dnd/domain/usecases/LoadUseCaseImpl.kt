package io.vbytsyuk.dnd.domain.usecases

import io.vbytsyuk.dnd.domain.DndRepository
import io.vbytsyuk.dnd.domain.Reader

open class LoadUseCaseImpl<Type>(
    private val reader: Reader<Type>,
    private val dao: DndRepository<Type>,
) : LoadUseCase<Type> {

    override suspend operator fun invoke(): List<Type> {
        val conditions = reader.read()
        if (dao.count() != 0) dao.clear()
        dao.insertAll(conditions)
        return conditions
    }
}
