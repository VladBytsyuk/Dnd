package io.vbytsyuk.dnd.data

import io.vbytsyuk.dnd.domain.Reader
import io.vbytsyuk.dnd.readFileAsString

open class ReaderImpl<DomainType, JsonType>(
    private val jsonParser: JsonParser<JsonType>,
    private val fileName: String,
    private val mapper: (JsonType) -> DomainType,
) : Reader<DomainType> {

    override fun read(): List<DomainType> {
        val stringJson = readFileAsString(fileName)
        val jsonList = jsonParser.parse(stringJson)
        return jsonList.map(mapper::invoke)
    }
}
