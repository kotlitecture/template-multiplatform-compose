package kotli.app.feature.showcases.presentation.dataflow.encryption

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs

object BasicEncryptionDestination : NavigationDestinationNoArgs() {

    override val id: String = "basic_encryption_screen"
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { BasicEncryptionScreen() }

}