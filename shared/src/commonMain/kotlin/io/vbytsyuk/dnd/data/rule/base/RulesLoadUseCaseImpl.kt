package io.vbytsyuk.dnd.data.rule.base

import io.vbytsyuk.dnd.data.rule.base.db.RuleRepository
import io.vbytsyuk.dnd.domain.rule.base.Rule
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class RulesLoadUseCaseImpl(
    reader: RulesReader,
    repository: RuleRepository,
) : LoadUseCaseImpl<Rule>(reader = reader, repository = repository)
