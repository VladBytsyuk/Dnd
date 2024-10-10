package io.vbytsyuk.dnd.db

fun interface RulebookDatabaseProvider {
    fun provide(): RulebookDatabase
}
