import kotli.app.App
import org.jetbrains.compose.web.renderComposable

/**
 * https://github.com/JetBrains/compose-multiplatform/tree/aa08279104cacc46a063a4322369a3b2bc66462f/tutorials/Web/Getting_Started
 */
fun main() {
    renderComposable("root") {
        App()
    }
}