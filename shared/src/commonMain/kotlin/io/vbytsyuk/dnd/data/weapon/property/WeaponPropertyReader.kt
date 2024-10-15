package io.vbytsyuk.dnd.data.weapon.property

import io.vbytsyuk.dnd.data.FileNames
import io.vbytsyuk.dnd.data.ReaderImpl
import io.vbytsyuk.dnd.data.weapon.property.json.WeaponPropertyJson
import io.vbytsyuk.dnd.data.weapon.property.json.WeaponPropertyJsonParser
import io.vbytsyuk.dnd.data.weapon.property.json.toDomain
import io.vbytsyuk.dnd.domain.weapon.property.WeaponProperty

class WeaponPropertyReader(
    jsonParser: WeaponPropertyJsonParser,
) : ReaderImpl<WeaponProperty, WeaponPropertyJson>(
    jsonParser = jsonParser,
    fileName = FileNames.WEAPON_PROPERTY,
    mapper = { it.toDomain() },
)
