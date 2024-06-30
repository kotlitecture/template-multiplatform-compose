package kotli.app.presentation.showcases.userflow.navigation.no_args.from

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotli.app.presentation.showcases.ShowcaseHintBlock
import kotli.app.presentation.showcases.userflow.navigation.no_args.NoArgsNavigationShowcase
import shared.presentation.viewmodel.provideViewModel
import shared.design.component.AppElevatedButton
import shared.design.container.AppFixedTopBarColumn

@Composable
fun NoArgsNavigationFromScreen() {
    val viewModel: NoArgsNavigationFromViewModel = provideViewModel()
    AppFixedTopBarColumn(
        title = NoArgsNavigationShowcase.label,
        onBack = viewModel::onBack,
        content = {
            ShowcaseHintBlock(
                text = """
                    By clicking on the button below, the app will navigate to the [NoArgsNavigationToDestination] using a pre-configured [NavigationStore] instance.

                    Both the from and to destinations are implemented using the included MVVM template.
                    
                    To create your own MVVM screen and make it available for navigation:
                    
                    1. Copy the content of the package `presentation/template/screen_without_args` to the required location for your screen.
                    
                    2. Rename the copied classes (Destination, Screen, and ViewModel) to the desired ones.
                    
                    3. Register the copied [Destination] class in `di/presentation/NavigationModule`.
                    
                    4. Register the copied [ViewModel] in `di/presentation/AppModule` viewModelFactory.
                    
                    5. Implement the logic of the screen in the copied [Screen] class.
                    
                    6. Navigate to your screen using the [NavigationStore] instance, which can be injected into any DI-managed class.
                """.trimIndent()
            )
            AppElevatedButton(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = viewModel::onNavigate,
                text = "Navigate"
            )
        }
    )
}