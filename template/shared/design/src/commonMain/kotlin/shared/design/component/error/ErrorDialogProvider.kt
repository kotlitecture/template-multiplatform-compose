@file:OptIn(ExperimentalMaterial3Api::class)

package shared.design.component.error

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import shared.core.state.DataState
import shared.core.state.StoreState

/**
 * Provides a composable UI component for handling data loading and error states.
 *
 * @param state The [StoreState] object containing the data state.
 */
@Composable
fun ErrorDialogProvider(state: StoreState) {
    val error = state.dataStateStore.asStateValue() as? DataState.Error ?: return
    AlertDialog(
        modifier = Modifier.padding(24.dp),
        onDismissRequest = state.dataStateStore::clear,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        ),
        title = {
            Text(text = error.id)
        },
        text = {
            Text(
                modifier = Modifier
                    .verticalScroll(rememberScrollState()),
                text = error.th.stackTraceToString()
            )
        },
        confirmButton = {}
    )
}