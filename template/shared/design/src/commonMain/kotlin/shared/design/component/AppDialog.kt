package shared.design.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import shared.design.theme.AppTheme
import shared.presentation.store.DataLoading
import shared.presentation.store.DataState

/**
 * Provides a composable UI component for handling data loading and error states.
 *
 * @param store The [DataState] object containing the data state.
 */
@Composable
fun AppErrorDialog(store: DataState<DataLoading>) {
    val error = store.asStateValue() as? DataLoading.Error ?: return
    AlertDialog(
        modifier = Modifier.padding(24.dp),
        onDismissRequest = store::clear,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        ),
        title = {
            Text(text = error.id.orEmpty())
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

/**
 * Alert dialog with title, text, and action button.
 *
 * @param modifier Modifier to be applied to the dialog.
 * @param onDismissRequest Callback to be invoked when the dialog is dismissed.
 * @param title Title of the dialog.
 * @param text Text content of the dialog.
 * @param confirmLabel Label for the action button.
 * @param confirmAction Callback to be invoked when the action button is clicked.
 */
@Composable
fun AppAlertDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    title: String,
    text: String,
    confirmLabel: String,
    confirmAction: () -> Unit,
    dismissLabel: String? = null,
    dismissAction: (() -> Unit)? = null
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        title = { AppText(text = title) },
        text = { AppText(text = text) },
        confirmButton = {
            AppTextButton(
                text = confirmLabel,
                onClick = confirmAction
            )
        },
        dismissButton = dismissLabel?.let {
            {
                AppTextButton(
                    text = dismissLabel,
                    onClick = dismissAction!!
                )
            }
        }
    )
}

/**
 * Dialog with custom content.
 *
 * @param modifier Modifier to be applied to the dialog.
 * @param onDismissRequest Callback to be invoked when the dialog is dismissed.
 * @param content Custom content to be displayed inside the dialog.
 */
@Composable
fun AppDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit
) {
    BasicAlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        content = content
    )
}

/**
 * Dialog content with custom layout.
 *
 * @param modifier Modifier to be applied to the dialog content.
 * @param content Custom content to be displayed inside the dialog content.
 */
@Composable
fun AppDialogContent(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(AppTheme.current.surface)
            .padding(24.dp)
    ) {
        content()
    }
}