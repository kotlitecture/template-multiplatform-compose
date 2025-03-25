package kotli.app.showcases.presentation.dataflow.cache.basic

import kotli.app.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object BasicCacheRoute {

    val screen = Showcase.Screen("Basic Cache Usage", this)

}