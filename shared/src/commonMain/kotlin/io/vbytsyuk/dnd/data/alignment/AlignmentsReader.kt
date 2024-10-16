package io.vbytsyuk.dnd.data.alignment

import io.vbytsyuk.dnd.data.FileNames
import io.vbytsyuk.dnd.data.ReaderImpl
import io.vbytsyuk.dnd.data.alignment.json.AlignmentJson
import io.vbytsyuk.dnd.data.alignment.json.AlignmentJsonParser
import io.vbytsyuk.dnd.data.alignment.json.toDomain
import io.vbytsyuk.dnd.domain.alignment.Alignment

class AlignmentsReader(
    jsonParser: AlignmentJsonParser,
) : ReaderImpl<Alignment, AlignmentJson>(
    jsonParser = jsonParser,
    fileName = FileNames.ALIGNMENTS,
    mapper = { it.toDomain() },
)
