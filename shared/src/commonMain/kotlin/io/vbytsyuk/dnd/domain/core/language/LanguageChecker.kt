package io.vbytsyuk.dnd.domain.core.language

import io.vbytsyuk.dnd.domain.core.util.Checker

class LanguageChecker(
    val specific: Set<Language> = emptySet(),
) : Checker<Language> {

    override fun check(arg: Language) = arg in specific

    operator fun plus(other: LanguageChecker): LanguageChecker = LanguageChecker(
        specific = specific + other.specific
    )
}
