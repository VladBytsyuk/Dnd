package io.vbytsyuk.dnd.data.equipment.base

import io.vbytsyuk.dnd.data.FileNames
import io.vbytsyuk.dnd.data.ReaderImpl
import io.vbytsyuk.dnd.data.equipment.base.json.EquipmentJson
import io.vbytsyuk.dnd.data.equipment.base.json.EquipmentJsonParser
import io.vbytsyuk.dnd.data.equipment.base.json.toDomain
import io.vbytsyuk.dnd.domain.equipment.base.Equipment

class EquipmentsReader(
    jsonParser: EquipmentJsonParser,
) : ReaderImpl<Equipment, EquipmentJson>(
    jsonParser = jsonParser,
    fileName = FileNames.EQUIPMENTS,
    mapper = { it.toDomain() },
)
