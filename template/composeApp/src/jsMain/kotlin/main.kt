import androidx.compose.ui.window.CanvasBasedWindow
import app.App

fun main() {
    CanvasBasedWindow(canvasElementId = "root") {
        App()
    }
}