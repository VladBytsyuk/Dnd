package io.vbytsyuk.dnd.data.language

import io.vbytsyuk.dnd.data.language.db.LanguageDndDaoImpl
import io.vbytsyuk.dnd.domain.language.Language
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class LanguagesLoadUseCaseImpl(
    reader: LanguagesReader,
    dao: LanguageDndDaoImpl,
) : LoadUseCaseImpl<Language>(reader = reader, dao = dao)
