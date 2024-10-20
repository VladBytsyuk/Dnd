package io.vbytsyuk.dnd.data.skill

import io.vbytsyuk.dnd.data.skill.db.SkillRepository
import io.vbytsyuk.dnd.domain.skill.Skill
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class SkillsLoadUseCaseImpl(
    reader: SkillsReader,
    repository: SkillRepository,
) : LoadUseCaseImpl<Skill>(reader = reader, repository = repository)
