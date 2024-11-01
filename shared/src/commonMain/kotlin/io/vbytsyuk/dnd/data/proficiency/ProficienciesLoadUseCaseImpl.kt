package io.vbytsyuk.dnd.data.proficiency

import io.vbytsyuk.dnd.data.proficiency.db.ProficiencyRepository
import io.vbytsyuk.dnd.domain.proficiency.Proficiency
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class ProficienciesLoadUseCaseImpl(
    reader: ProficienciesReader,
    repository: ProficiencyRepository,
) : LoadUseCaseImpl<Proficiency>(reader = reader, repository = repository)
