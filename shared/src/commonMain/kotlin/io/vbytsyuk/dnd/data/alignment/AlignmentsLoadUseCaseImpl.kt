package io.vbytsyuk.dnd.data.alignment

import io.vbytsyuk.dnd.data.alignment.db.AlignmentRepository
import io.vbytsyuk.dnd.domain.alignment.Alignment
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class AlignmentsLoadUseCaseImpl(
    reader: AlignmentsReader,
    repository: AlignmentRepository,
) : LoadUseCaseImpl<Alignment>(reader = reader, repository = repository)
