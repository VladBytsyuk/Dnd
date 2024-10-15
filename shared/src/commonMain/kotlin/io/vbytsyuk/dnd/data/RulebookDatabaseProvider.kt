package io.vbytsyuk.dnd.data

fun interface RulebookDatabaseProvider {
    fun provide(): RulebookRoomDatabase
}
