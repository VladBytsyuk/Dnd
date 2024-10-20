package io.vbytsyuk.dnd.data.rule.section

import io.vbytsyuk.dnd.data.rule.section.db.RuleSectionRepository
import io.vbytsyuk.dnd.domain.rule.section.RuleSection
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class RuleSectionsLoadUseCaseImpl(
    reader: RuleSectionsReader,
    repository: RuleSectionRepository,
) : LoadUseCaseImpl<RuleSection>(reader = reader, repository = repository)
