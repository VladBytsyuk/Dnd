package io.vbytsyuk.dnd.data.damage.type

import io.vbytsyuk.dnd.data.damage.type.db.DamageTypeDaoImpl
import io.vbytsyuk.dnd.domain.damage.type.DamageType
import io.vbytsyuk.dnd.domain.usecases.LoadUseCase

class DamageTypeLoadUseCase(
    reader: DamageReader,
    dao: DamageTypeDaoImpl,
) : LoadUseCase<DamageType>(reader = reader, dao = dao)
