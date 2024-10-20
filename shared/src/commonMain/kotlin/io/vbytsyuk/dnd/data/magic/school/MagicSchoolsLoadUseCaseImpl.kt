package io.vbytsyuk.dnd.data.magic.school

import io.vbytsyuk.dnd.data.magic.school.db.MagicSchoolRepository
import io.vbytsyuk.dnd.domain.magic.school.MagicSchool
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class MagicSchoolsLoadUseCaseImpl(
    reader: MagicSchoolsReader,
    repository: MagicSchoolRepository,
) : LoadUseCaseImpl<MagicSchool>(reader = reader, repository = repository)
