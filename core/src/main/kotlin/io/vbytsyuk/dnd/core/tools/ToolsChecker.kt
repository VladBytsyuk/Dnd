package io.vbytsyuk.dnd.core.tools

import io.vbytsyuk.dnd.core.util.Checker

class ToolsChecker(
    val specific: Set<Tools> = emptySet(),
) : Checker<Tools> {

    override fun check(arg: Tools): Boolean = arg in specific

    operator fun plus(other: ToolsChecker): ToolsChecker = ToolsChecker(
        specific = specific + other.specific,
    )
}
