package io.vbytsyuk.dnd.data.equipment.category

import io.vbytsyuk.dnd.data.equipment.category.db.EquipmentCategoryRepository
import io.vbytsyuk.dnd.domain.equipment.category.EquipmentCategory
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class EquipmentCategoriesLoadUseCaseImpl(
    reader: EquipmentCategoriesReader,
    repository: EquipmentCategoryRepository,
) : LoadUseCaseImpl<EquipmentCategory>(reader = reader, repository = repository)
