package shared.design.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppCircularProgressIndicator() {
    CircularProgressIndicator(
        modifier = Modifier
            .size(40.dp),
        strokeWidth = 3.dp
    )
}