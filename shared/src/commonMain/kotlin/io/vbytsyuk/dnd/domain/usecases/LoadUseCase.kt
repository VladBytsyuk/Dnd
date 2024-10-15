package io.vbytsyuk.dnd.domain.usecases

interface LoadUseCase<Type> {
    suspend operator fun invoke(): List<Type>
}
