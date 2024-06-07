package io.vbytsyuk.dnd.core.util

fun interface Checker<T> {
    fun check(arg: T): Boolean

    operator fun plus(other: Checker<T>) = Checker<T> { this.check(it) || other.check(it) }
}
