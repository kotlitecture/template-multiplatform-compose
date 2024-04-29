package app.showcases.navigation.args.from

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.showcases.ShowcaseHintBlock
import app.showcases.navigation.args.ArgsNavigationShowcase
import shared.core.provideViewModel
import shared.core.state.StoreObject
import shared.design.container.FixedTopBarColumnLayout

@Composable
fun ArgsNavigationFromScreen() {
    val viewModel: ArgsNavigationFromViewModel = provideViewModel()
    FixedTopBarColumnLayout(
        title = ArgsNavigationShowcase.label,
        onBack = viewModel::onBack,
        content = {
            ShowcaseHintBlock(
                text = """
                    By clicking on the button below, the app will navigate to the [ArgsNavigationToDestination] using a pre-configured [NavigationState] instance.
                    
                    Navigation will be done with [Data] instance filled with property [userName] from input field.
                    
                    Both the from and to destinations are implemented using the included MVVM template.
                    
                    To create your own MVVM screen with arguments and make it available for navigation:
                    
                    1. Copy the content of the package `app/ui/screen/template` to the required location for your screen.
                    2. Rename the copied classes (Destination, Screen, and ViewModel) to the desired ones.
                    3. Register the copied [Destination] class in `app/di/state/ProvidesNavigationState`.
                    4. Implement the logic of the screen in the copied [Screen] class.
                    5. Navigate to your screen using the [NavigationState] instance, which can be injected into any DI-managed class.
                """.trimIndent()
            )
            UserNameBlock(viewModel.userNameStore)
            ElevatedButton(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = viewModel::onNavigate,
                content = { Text(text = "Navigate") }
            )
        }
    )
}

@Composable
private fun UserNameBlock(store: StoreObject<String>) {
    TextField(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        value = store.asStateValue().orEmpty(),
        onValueChange = store::set,
        placeholder = {
            Text(text = "User name")
        }
    )
}