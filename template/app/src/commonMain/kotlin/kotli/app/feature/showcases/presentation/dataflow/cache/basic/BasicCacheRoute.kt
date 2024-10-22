package kotli.app.feature.showcases.presentation.dataflow.cache.basic

import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object BasicCacheRoute {

    val screen = Showcase.Screen("Basic In-Memory Cache Usage", this)

}