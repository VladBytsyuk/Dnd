package io.vbytsyuk.dnd.data.ability.score

import io.vbytsyuk.dnd.data.ability.score.db.AbilityScoreDndDaoImpl
import io.vbytsyuk.dnd.domain.ability.score.AbilityScore
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class AbilityScoresLoadUseCaseImpl(
    reader: AbilityScoresReader,
    dao: AbilityScoreDndDaoImpl,
) : LoadUseCaseImpl<AbilityScore>(reader = reader, dao = dao)
