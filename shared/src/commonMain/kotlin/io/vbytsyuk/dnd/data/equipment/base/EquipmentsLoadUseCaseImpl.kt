package io.vbytsyuk.dnd.data.equipment.base

import io.vbytsyuk.dnd.data.equipment.base.db.EquipmentRepository
import io.vbytsyuk.dnd.domain.equipment.base.Equipment
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class EquipmentsLoadUseCaseImpl(
    reader: EquipmentsReader,
    repository: EquipmentRepository,
) : LoadUseCaseImpl<Equipment>(reader = reader, repository = repository)
