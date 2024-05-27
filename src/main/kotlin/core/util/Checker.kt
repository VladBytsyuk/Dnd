package io.vbytsyuk.dnd.core.util

fun interface Checker<T> {
    fun check(arg: T): Boolean
}
