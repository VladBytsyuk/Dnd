package io.vbytsyuk.dnd.data.background

import io.vbytsyuk.dnd.data.background.db.BackgroundRepository
import io.vbytsyuk.dnd.domain.background.Background
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl

class BackgroundsLoadUseCaseImpl(
    reader: BackgroundsReader,
    repository: BackgroundRepository,
) : LoadUseCaseImpl<Background>(reader = reader, repository = repository)
