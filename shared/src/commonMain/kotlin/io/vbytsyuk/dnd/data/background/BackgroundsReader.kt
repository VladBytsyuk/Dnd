package io.vbytsyuk.dnd.data.background

import io.vbytsyuk.dnd.data.FileNames
import io.vbytsyuk.dnd.data.ReaderImpl
import io.vbytsyuk.dnd.data.background.json.BackgroundJson
import io.vbytsyuk.dnd.data.background.json.BackgroundJsonParser
import io.vbytsyuk.dnd.data.background.json.toDomain
import io.vbytsyuk.dnd.domain.background.Background

class BackgroundsReader(
    jsonParser: BackgroundJsonParser,
) : ReaderImpl<Background, BackgroundJson>(
    jsonParser = jsonParser,
    fileName = FileNames.BACKGROUNDS,
    mapper = { it.toDomain() },
)
