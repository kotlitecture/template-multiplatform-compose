import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import app.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Template"
    ) {
        App()
    }
}