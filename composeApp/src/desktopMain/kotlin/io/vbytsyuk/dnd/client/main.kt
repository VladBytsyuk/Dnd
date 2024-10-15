package io.vbytsyuk.dnd.client

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.vbytsyuk.dnd.data.condition.ConditionLoadUseCase
import io.vbytsyuk.dnd.data.damage.type.DamageTypeLoadUseCase
import io.vbytsyuk.dnd.di.Koin
import kotlinx.coroutines.runBlocking

fun main() {
    val app = Koin.init()
    val conditionUseCase: ConditionLoadUseCase = app.koin.get()
    val damageTypeUseCase: DamageTypeLoadUseCase = app.koin.get()
    val conditions = runBlocking { conditionUseCase.invoke() }
    val damageTypes = runBlocking { damageTypeUseCase.invoke() }
    applicationRun(conditions.toString() + damageTypes.toString())
}

private fun applicationRun(text: String) = application {
    Window(
        onCloseRequest = {
            Koin.stop()
            exitApplication()
        },
        title = "dnd-desktop",
    ) {
        App(text)
    }
}
