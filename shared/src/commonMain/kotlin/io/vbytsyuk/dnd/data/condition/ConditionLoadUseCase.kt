package io.vbytsyuk.dnd.data.condition

import io.vbytsyuk.dnd.data.condition.db.ConditionDndDaoImpl
import io.vbytsyuk.dnd.domain.condition.Condition
import io.vbytsyuk.dnd.domain.usecases.LoadUseCase

class ConditionLoadUseCase(
    reader: ConditionReader,
    dao: ConditionDndDaoImpl,
) : LoadUseCase<Condition>(reader = reader, dao = dao)
