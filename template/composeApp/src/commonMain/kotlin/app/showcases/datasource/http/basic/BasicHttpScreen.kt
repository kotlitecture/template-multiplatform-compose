package app.showcases.datasource.http.basic

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.appViewModel
import app.showcases.ShowcaseHintBlock
import app.ui.container.FixedTopBarColumnLayout
import core.ui.state.StoreObject

@Composable
fun BasicHttpScreen() {
    val viewModel = appViewModel(BasicHttpViewModel::class)
    FixedTopBarColumnLayout(
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
            ElevatedButton(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = viewModel::onFetchIp,
                content = { Text(text = "Fetch my ip") }
            )
            IpBlock(viewModel.ipStore)
        }
    )
}

@Composable
private fun IpBlock(ipStore: StoreObject<String>) {
    val ip = ipStore.asStateValue() ?: return
    Text(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = ip
    )
}