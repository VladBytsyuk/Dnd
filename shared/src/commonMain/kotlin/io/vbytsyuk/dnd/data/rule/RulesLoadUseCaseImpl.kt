package io.vbytsyuk.dnd.data.rule

import io.vbytsyuk.dnd.data.rule.db.RuleDndDaoImpl
import io.vbytsyuk.dnd.domain.rule.Rule
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class RulesLoadUseCaseImpl(
    reader: RulesReader,
    dao: RuleDndDaoImpl,
) : LoadUseCaseImpl<Rule>(reader = reader, dao = dao)
