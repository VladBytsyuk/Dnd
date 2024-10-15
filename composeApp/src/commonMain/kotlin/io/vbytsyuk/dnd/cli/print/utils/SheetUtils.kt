package io.vbytsyuk.dnd.cli.print.utils

import io.vbytsyuk.dnd.domain.sheet.Sheet


fun Sheet.Health.toStringOutput() =
    "$currentHp${if (temporaryHp > 0) "(+$temporaryHp)" else ""}/$maxHp hp " +
            "(${hitDices.amount}/${hitDices.max} ${hitDices.dice} hit dices)"

