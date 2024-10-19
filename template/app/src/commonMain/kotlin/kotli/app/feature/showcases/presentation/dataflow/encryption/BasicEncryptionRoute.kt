package kotli.app.feature.showcases.presentation.dataflow.encryption

import kotli.app.AppRoute
import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object BasicEncryptionRoute : AppRoute {

    val screen = Showcase.Screen("Basic Encryption Usage", this)

}