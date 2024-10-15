package io.vbytsyuk.dnd.client

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.vbytsyuk.dnd.di.Koin
import io.vbytsyuk.dnd.domain.usecases.ConditionLoadUseCase
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.inject


fun main() {
    init()
    val useCase: ConditionLoadUseCase by inject(ConditionLoadUseCase::class.java)
    val conditions = runBlocking { useCase.invoke() }
    applicationRun(conditions.toString())
}

private fun init() {
    Koin.init()
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
