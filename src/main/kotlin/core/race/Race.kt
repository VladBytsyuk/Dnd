package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.units.Distance
import io.vbytsyuk.dnd.core.units.Size
import io.vbytsyuk.dnd.core.util.Checker
import io.vbytsyuk.dnd.core.weapon.Weapon

sealed class Race(
    val bonusStatBlock: StatBlock = StatBlock(),
    val size: Size,
    val baseSpeed: Speed,
    val darkVision: Distance?,
    val proficiencies: Proficiencies,

)
