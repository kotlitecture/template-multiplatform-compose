package kotli.app.showcases.navigation.args.from

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotli.app.showcases.ShowcaseHintBlock
import kotli.app.showcases.navigation.args.ArgsNavigationShowcase
import shared.presentation.viewmodel.provideViewModel
import shared.presentation.store.DataState
import shared.design.component.AppElevatedButton
import shared.design.component.AppTextField
import shared.design.container.AppFixedTopBarColumn

@Composable
fun ArgsNavigationFromScreen() {
    val viewModel: ArgsNavigationFromViewModel = provideViewModel()
    AppFixedTopBarColumn(
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
                    
                    4. Register the copied [ViewModel] in app/App#AppViewModelFactory.
                    
                    5. Implement the logic of the screen in the copied [Screen] class.
                    
                    6. Navigate to your screen using the [NavigationState] instance, which can be injected into any DI-managed class.
                """.trimIndent()
            )
            UserNameBlock(viewModel.userNameStore)
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

@Composable
private fun UserNameBlock(store: DataState<String>) {
    AppTextField(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        valueStore = store,
        placeholder = "User name"
    )
}