package io.vbytsyuk.dnd.data.damage.type

import io.vbytsyuk.dnd.data.FileNames
import io.vbytsyuk.dnd.data.ReaderImpl
import io.vbytsyuk.dnd.data.damage.type.json.DamageTypeJson
import io.vbytsyuk.dnd.data.damage.type.json.DamageTypeJsonParser
import io.vbytsyuk.dnd.data.damage.type.json.toDomain
import io.vbytsyuk.dnd.domain.damage.type.DamageType

class DamageTypesReader(
    jsonParser: DamageTypeJsonParser,
) : ReaderImpl<DamageType, DamageTypeJson>(
    jsonParser = jsonParser,
    fileName = FileNames.DAMAGE_TYPES,
    mapper = { it.toDomain() },
)
