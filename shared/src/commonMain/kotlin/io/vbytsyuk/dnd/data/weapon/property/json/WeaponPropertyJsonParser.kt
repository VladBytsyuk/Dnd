package io.vbytsyuk.dnd.data.weapon.property.json

import io.vbytsyuk.dnd.data.JsonParser
import kotlinx.serialization.json.Json


class WeaponPropertyJsonParser(
    private val json: Json,
) : JsonParser<WeaponPropertyJson> {

    override fun parse(jsonString: String): List<WeaponPropertyJson> =
        json.decodeFromString<List<WeaponPropertyJson>>(jsonString)
}
