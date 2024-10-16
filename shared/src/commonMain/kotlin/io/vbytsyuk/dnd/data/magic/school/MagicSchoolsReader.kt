package io.vbytsyuk.dnd.data.magic.school

import io.vbytsyuk.dnd.data.FileNames
import io.vbytsyuk.dnd.data.ReaderImpl
import io.vbytsyuk.dnd.data.magic.school.json.MagicSchoolJson
import io.vbytsyuk.dnd.data.magic.school.json.MagicSchoolJsonParser
import io.vbytsyuk.dnd.data.magic.school.json.toDomain
import io.vbytsyuk.dnd.domain.magic.school.MagicSchool

class MagicSchoolsReader(
    jsonParser: MagicSchoolJsonParser,
) : ReaderImpl<MagicSchool, MagicSchoolJson>(
    jsonParser = jsonParser,
    fileName = FileNames.MAGIC_SCHOOL,
    mapper = { it.toDomain() },
)
