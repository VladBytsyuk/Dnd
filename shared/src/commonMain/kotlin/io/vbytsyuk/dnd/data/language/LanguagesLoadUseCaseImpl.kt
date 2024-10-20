package io.vbytsyuk.dnd.data.language

import io.vbytsyuk.dnd.data.language.db.LanguageRepository
import io.vbytsyuk.dnd.domain.language.Language
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class LanguagesLoadUseCaseImpl(
    reader: LanguagesReader,
    repository: LanguageRepository,
) : LoadUseCaseImpl<Language>(reader = reader, dao = repository)
