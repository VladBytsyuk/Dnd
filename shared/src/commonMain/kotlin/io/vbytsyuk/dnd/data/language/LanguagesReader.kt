package io.vbytsyuk.dnd.data.language

import io.vbytsyuk.dnd.data.FileNames
import io.vbytsyuk.dnd.data.ReaderImpl
import io.vbytsyuk.dnd.data.language.json.LanguageJson
import io.vbytsyuk.dnd.data.language.json.LanguageJsonParser
import io.vbytsyuk.dnd.data.language.json.toDomain
import io.vbytsyuk.dnd.domain.language.Language

class LanguagesReader(
    jsonParser: LanguageJsonParser,
) : ReaderImpl<Language, LanguageJson>(
    jsonParser = jsonParser,
    fileName = FileNames.LANGUAGE,
    mapper = { it.toDomain() },
)
