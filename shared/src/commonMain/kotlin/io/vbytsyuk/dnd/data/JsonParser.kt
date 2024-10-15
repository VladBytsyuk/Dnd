package io.vbytsyuk.dnd.data

interface JsonParser<T> {

    fun parse(jsonString: String): List<T>
}
