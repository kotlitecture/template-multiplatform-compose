package kotli.app.feature.showcases.presentation.dataflow.encryption

import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object BasicEncryptionRoute {

    val screen = Showcase.Screen("Basic Encryption Usage", this)

}