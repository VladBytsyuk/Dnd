package io.vbytsyuk.dnd.client

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.vbytsyuk.dnd.Greeting
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(text:String) {
    MaterialTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(),
        ) {
            val greeting = remember { Greeting().greet() }
            Text("Compose: $greeting")
            Text("Content: $text")
        }
    }
}
