package io.vbytsyuk.dnd.data.condition

import io.vbytsyuk.dnd.data.condition.db.ConditionDndDaoImpl
import io.vbytsyuk.dnd.domain.condition.Condition
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class ConditionLoadUseCaseImpl(
    reader: ConditionReader,
    dao: ConditionDndDaoImpl,
) : LoadUseCaseImpl<Condition>(reader = reader, dao = dao)
