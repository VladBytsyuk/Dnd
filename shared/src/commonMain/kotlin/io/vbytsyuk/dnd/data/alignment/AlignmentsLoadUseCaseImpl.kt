package io.vbytsyuk.dnd.data.alignment

import io.vbytsyuk.dnd.data.alignment.db.AlignmentDndDaoImpl
import io.vbytsyuk.dnd.domain.alignment.Alignment
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class AlignmentsLoadUseCaseImpl(
    reader: AlignmentsReader,
    dao: AlignmentDndDaoImpl,
) : LoadUseCaseImpl<Alignment>(reader = reader, dao = dao)
