package io.vbytsyuk.dnd.data.rule.section

import io.vbytsyuk.dnd.data.rule.section.db.RuleSectionDndDaoImpl
import io.vbytsyuk.dnd.domain.rule.section.RuleSection
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class RuleSectionsLoadUseCaseImpl(
    reader: RuleSectionsReader,
    dao: RuleSectionDndDaoImpl,
) : LoadUseCaseImpl<RuleSection>(reader = reader, dao = dao)
