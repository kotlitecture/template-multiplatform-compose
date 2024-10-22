package kotli.app.feature.showcases.presentation.dataflow.ai.gemini

import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object GeminiRoute {

    val screen = Showcase.Screen("Gemini AI", this)

}