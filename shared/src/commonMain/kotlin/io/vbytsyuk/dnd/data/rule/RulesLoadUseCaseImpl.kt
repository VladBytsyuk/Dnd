package io.vbytsyuk.dnd.data.rule

import io.vbytsyuk.dnd.data.rule.db.RuleRepository
import io.vbytsyuk.dnd.domain.rule.Rule
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class RulesLoadUseCaseImpl(
    reader: RulesReader,
    repository: RuleRepository,
) : LoadUseCaseImpl<Rule>(reader = reader, dao = repository)
