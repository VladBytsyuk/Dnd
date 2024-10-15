package io.vbytsyuk.dnd.client

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.vbytsyuk.dnd.di.Koin
import io.vbytsyuk.dnd.domain.usecases.LoadRulebookUseCase
import kotlinx.coroutines.runBlocking

fun main() {
    val app = Koin.init()
    val useCase: LoadRulebookUseCase = app.koin.get()
    val rulebook = runBlocking { useCase.invoke() }
    applicationRun(rulebook.toString())
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
