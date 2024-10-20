package io.vbytsyuk.dnd.data.skill

import io.vbytsyuk.dnd.data.FileNames
import io.vbytsyuk.dnd.data.ReaderImpl
import io.vbytsyuk.dnd.data.skill.json.SkillJson
import io.vbytsyuk.dnd.data.skill.json.SkillJsonParser
import io.vbytsyuk.dnd.data.skill.json.toDomain
import io.vbytsyuk.dnd.domain.skill.Skill

class SkillsReader(
    jsonParser: SkillJsonParser,
) : ReaderImpl<Skill, SkillJson>(
    jsonParser = jsonParser,
    fileName = FileNames.SKILLS,
    mapper = { it.toDomain() },
)
