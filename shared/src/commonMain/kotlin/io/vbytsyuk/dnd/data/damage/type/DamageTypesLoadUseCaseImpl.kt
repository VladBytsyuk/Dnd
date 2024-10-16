package io.vbytsyuk.dnd.data.damage.type

import io.vbytsyuk.dnd.data.damage.type.db.DamageTypeDaoImpl
import io.vbytsyuk.dnd.domain.damage.type.DamageType
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class DamageTypesLoadUseCaseImpl(
    reader: DamageTypesReader,
    dao: DamageTypeDaoImpl,
) : LoadUseCaseImpl<DamageType>(reader = reader, dao = dao)
