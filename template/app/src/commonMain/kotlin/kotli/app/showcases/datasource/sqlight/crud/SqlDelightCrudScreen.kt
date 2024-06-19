package kotli.app.showcases.datasource.sqlight.crud

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.design.component.AppElevatedButton
import shared.design.container.AppFixedTopBarColumn
import shared.presentation.provideViewModel

@Composable
fun BasicHttpScreen() {
    val viewModel: SqlDelightCrudViewModel = provideViewModel()
    AppFixedTopBarColumn(
        title = SqlDelightCrudShowcase.label,
        onBack = viewModel::onBack,
        content = {
            AppElevatedButton(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = viewModel::onAdd,
                text = "Add new user"
            )
        }
    )
}