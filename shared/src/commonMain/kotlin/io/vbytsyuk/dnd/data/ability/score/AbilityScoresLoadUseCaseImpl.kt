package io.vbytsyuk.dnd.data.ability.score

import io.vbytsyuk.dnd.data.ability.score.db.AbilityScoreRepository
import io.vbytsyuk.dnd.domain.ability.score.AbilityScore
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class AbilityScoresLoadUseCaseImpl(
    reader: AbilityScoresReader,
    repository: AbilityScoreRepository,
) : LoadUseCaseImpl<AbilityScore>(reader = reader, dao = repository)
