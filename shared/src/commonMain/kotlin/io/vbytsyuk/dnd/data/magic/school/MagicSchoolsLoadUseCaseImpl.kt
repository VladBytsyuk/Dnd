package io.vbytsyuk.dnd.data.magic.school

import io.vbytsyuk.dnd.data.magic.school.db.MagicSchoolDndDaoImpl
import io.vbytsyuk.dnd.domain.magic.school.MagicSchool
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class MagicSchoolsLoadUseCaseImpl(
    reader: MagicSchoolsReader,
    dao: MagicSchoolDndDaoImpl,
) : LoadUseCaseImpl<MagicSchool>(reader = reader, dao = dao)
