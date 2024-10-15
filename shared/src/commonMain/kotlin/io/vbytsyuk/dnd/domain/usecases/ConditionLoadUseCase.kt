package io.vbytsyuk.dnd.domain.usecases

import io.vbytsyuk.dnd.domain.condition.Condition
import io.vbytsyuk.dnd.domain.condition.ConditionDao
import io.vbytsyuk.dnd.domain.condition.Reader

class ConditionLoadUseCase(
    private val conditionReader: Reader<Condition>,
    private val conditionDao: ConditionDao,
) {

    suspend operator fun invoke(): List<Condition> {
        val conditions = conditionReader.read()
        if (conditionDao.count() != 0) conditionDao.clear()
        conditionDao.insertAll(conditions)
        return conditions
    }
}
