package io.vbytsyuk.dnd.domain.condition

interface Reader<T> {

    fun read(): List<T>
}
