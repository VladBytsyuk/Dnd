package io.vbytsyuk.dnd.data.proficiency

import io.vbytsyuk.dnd.data.FileNames
import io.vbytsyuk.dnd.data.ReaderImpl
import io.vbytsyuk.dnd.data.proficiency.json.ProficiencyJson
import io.vbytsyuk.dnd.data.proficiency.json.ProficiencyJsonParser
import io.vbytsyuk.dnd.data.proficiency.json.toDomain
import io.vbytsyuk.dnd.domain.proficiency.Proficiency

class ProficienciesReader(
    jsonParser: ProficiencyJsonParser,
) : ReaderImpl<Proficiency, ProficiencyJson>(
    jsonParser = jsonParser,
    fileName = FileNames.PROFICIENCIES,
    mapper = { it.toDomain() },
)
