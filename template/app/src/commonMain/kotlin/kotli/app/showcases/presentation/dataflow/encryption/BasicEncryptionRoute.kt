package kotli.app.showcases.presentation.dataflow.encryption

import kotli.app.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object BasicEncryptionRoute {

    val screen = Showcase.Screen("Basic Encryption Usage", this)

}