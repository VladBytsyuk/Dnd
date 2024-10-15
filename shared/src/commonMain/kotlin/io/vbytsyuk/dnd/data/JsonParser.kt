package io.vbytsyuk.dnd.data

interface JsonParser<T> {

    fun parse(fileName: String): List<T>
}
