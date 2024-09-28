package kotli.app.presentation.showcases.userflow.navigation.args.from

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotli.app.presentation.showcases.ShowcaseHintBlock
import kotli.app.presentation.showcases.userflow.navigation.args.ArgsNavigationShowcase
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
                    By clicking on the button below, the app will navigate to the [ArgsNavigationToDestination] using a pre-configured [NavigationStore] instance.
                    
                    Navigation will be done with [Data] instance filled with property [userName] from input field.
                    
                    Both the from and to destinations are implemented using the included MVVM template.
                    
                    To create your own MVVM screen with arguments and make it available for navigation:
                    
                    1. Copy the content of the package `presentation/template/screen_with_args` to the required location for your screen.
                    
                    2. Rename the copied classes (Destination, Screen, and ViewModel) to the desired ones.
                    
                    3. Register the copied [Destination] class in `di/presentation/NavigationModule`.
                    
                    4. Register the copied [ViewModel] in `di/presentation/AppModule` viewModelFactory.
                    
                    5. Implement the logic of the screen in the copied [Screen] class.
                    
                    6. Navigate to your screen using the [NavigationStore] instance, which can be injected into any DI-managed class.
                """.trimIndent()
            )
            UserNameBlock(viewModel.userNameState)
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
private fun UserNameBlock(state: MutableState<String>) {
    AppTextField(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        valueState = state,
        placeholder = "User name"
    )
}