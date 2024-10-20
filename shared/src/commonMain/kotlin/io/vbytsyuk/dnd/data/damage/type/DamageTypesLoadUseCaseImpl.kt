package io.vbytsyuk.dnd.data.damage.type

import io.vbytsyuk.dnd.data.damage.type.db.DamageTypeRepository
import io.vbytsyuk.dnd.domain.damage.type.DamageType
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class DamageTypesLoadUseCaseImpl(
    reader: DamageTypesReader,
    repository: DamageTypeRepository,
) : LoadUseCaseImpl<DamageType>(reader = reader, repository = repository)
