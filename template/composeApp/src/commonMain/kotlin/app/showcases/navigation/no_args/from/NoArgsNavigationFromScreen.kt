package app.showcases.navigation.no_args.from

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.showcases.ShowcaseHintBlock
import app.showcases.navigation.no_args.NoArgsNavigationShowcase
import shared.core.provideViewModel
import shared.design.container.FixedTopBarColumnLayout

@Composable
fun NoArgsNavigationFromScreen() {
    val viewModel: NoArgsNavigationFromViewModel = provideViewModel()
    FixedTopBarColumnLayout(
        title = NoArgsNavigationShowcase.label,
        onBack = viewModel::onBack,
        content = {
            ShowcaseHintBlock(
                text = """
                    By clicking on the button below, the app will navigate to the [NoArgsNavigationToDestination] using a pre-configured [NavigationState] instance.

                    Both the from and to destinations are implemented using the included MVVM template.
                    
                    To create your own MVVM screen and make it available for navigation:
                    
                    1. Copy the content of the package `app/ui/screen/template_no_args` to the required location for your screen.
                    2. Rename the copied classes (Destination, Screen, and ViewModel) to the desired ones.
                    3. Register the copied [Destination] class in `app/di/state/ProvidesNavigationState`.
                    4. Implement the logic of the screen in the copied [Screen] class.
                    5. Navigate to your screen using the [NavigationState] instance, which can be injected into any DI-managed class.
                """.trimIndent()
            )
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