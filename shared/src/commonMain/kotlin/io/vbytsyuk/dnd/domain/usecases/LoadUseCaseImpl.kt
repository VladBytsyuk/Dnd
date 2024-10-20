package io.vbytsyuk.dnd.domain.usecases

import io.vbytsyuk.dnd.domain.DndRepository
import io.vbytsyuk.dnd.domain.Reader

open class LoadUseCaseImpl<Type>(
    private val reader: Reader<Type>,
    private val repository: DndRepository<Type>,
) : LoadUseCase<Type> {

    override suspend operator fun invoke(): List<Type> {
        val conditions = reader.read()
        if (repository.count() != 0) repository.clear()
        repository.insertAll(conditions)
        return conditions
    }
}
