import androidx.compose.ui.window.CanvasBasedWindow
import kotli.app.App
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    onWasmReady {
        CanvasBasedWindow(canvasElementId = "composeAppTarget") {
            App()
        }
    }
}