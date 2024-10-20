package io.vbytsyuk.dnd.data.condition

import io.vbytsyuk.dnd.data.condition.db.ConditionRepository
import io.vbytsyuk.dnd.domain.condition.Condition
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class ConditionsLoadUseCaseImpl(
    reader: ConditionsReader,
    repository: ConditionRepository,
) : LoadUseCaseImpl<Condition>(reader = reader, repository = repository)
