package kotli.app.feature.showcases.presentation.dataflow.ai.gemini

import kotli.app.AppRoute
import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object GeminiRoute : AppRoute {

    val screen = Showcase.Screen("Gemini AI", this)

}