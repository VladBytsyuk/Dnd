package io.vbytsyuk.dnd.domain

interface Reader<T> {

    fun read(): List<T>
}
