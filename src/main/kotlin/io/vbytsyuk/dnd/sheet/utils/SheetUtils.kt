package io.vbytsyuk.dnd.sheet.utils

import io.vbytsyuk.dnd.sheet.Sheet


fun Sheet.Health.toStringOutput() =
    "$currentHp${if (temporaryHp > 0) "(+$temporaryHp)" else ""}/$maxHp hp " +
            "(${hitDices.amount}/${hitDices.max} ${hitDices.dice} hit dices)"

