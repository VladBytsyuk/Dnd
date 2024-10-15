package io.vbytsyuk.dnd.data.weapon.property

import io.vbytsyuk.dnd.data.weapon.property.db.WeaponPropertyDaoImpl
import io.vbytsyuk.dnd.domain.usecases.LoadUseCaseImpl
import io.vbytsyuk.dnd.domain.weapon.property.WeaponProperty

class WeaponPropertyLoadUseCaseImpl(
    reader: WeaponPropertyReader,
    dao: WeaponPropertyDaoImpl,
) : LoadUseCaseImpl<WeaponProperty>(reader = reader, dao = dao)
