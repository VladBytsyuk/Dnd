package io.vbytsyuk.dnd.data.ability.score

import io.vbytsyuk.dnd.data.FileNames
import io.vbytsyuk.dnd.data.ReaderImpl
import io.vbytsyuk.dnd.data.ability.score.json.AbilityScoreJson
import io.vbytsyuk.dnd.data.ability.score.json.AbilityScoreJsonParser
import io.vbytsyuk.dnd.data.ability.score.json.toDomain
import io.vbytsyuk.dnd.domain.ability.score.AbilityScore

class AbilityScoresReader(
    jsonParser: AbilityScoreJsonParser,
) : ReaderImpl<AbilityScore, AbilityScoreJson>(
    jsonParser = jsonParser,
    fileName = FileNames.ABILITY_SCORES,
    mapper = { it.toDomain() },
)
