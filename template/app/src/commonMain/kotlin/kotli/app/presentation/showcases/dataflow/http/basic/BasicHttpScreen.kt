package kotli.app.presentation.showcases.dataflow.http.basic

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotli.app.presentation.showcases.ShowcaseHintBlock
import shared.presentation.viewmodel.provideViewModel
import shared.presentation.store.DataState
import shared.design.component.AppElevatedButton
import shared.design.component.AppText
import shared.design.container.AppFixedTopBarColumn

@Composable
fun BasicHttpScreen() {
    val viewModel: BasicHttpViewModel = provideViewModel()
    AppFixedTopBarColumn(
        title = BasicHttpShowcase.label,
        onBack = viewModel::onBack,
        content = {
            ShowcaseHintBlock(
                text = """
                    By clicking on the button, the app will attempt to retrieve the device's IP address using a public HTTP API, following this flow:
                    
                    1. Delay the request for a brief period and display a loading state.
                    
                    2. Send the request to obtain the device's IP address.
                    
                    3. If the request succeeds, display the IP address.
                    
                    4. If an error occurs, display the error's stack trace.
                    
                    In case of any issue, also check the system console for additional information.
                """.trimIndent()
            )
            AppElevatedButton(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = viewModel::onFetchIp,
                text = "Fetch my ip"
            )
            IpBlock(viewModel.ipState)
        }
    )
}

@Composable
private fun IpBlock(ipStore: DataState<String>) {
    AppText(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = ipStore.asStateValue()
    )
}