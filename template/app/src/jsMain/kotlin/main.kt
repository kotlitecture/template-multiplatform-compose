import androidx.compose.ui.window.CanvasBasedWindow
import kotli.app.app.App
import org.jetbrains.skiko.wasm.onWasmReady

fun main() = onWasmReady {
    CanvasBasedWindow(canvasElementId = "appTarget") {
        App()
    }
}