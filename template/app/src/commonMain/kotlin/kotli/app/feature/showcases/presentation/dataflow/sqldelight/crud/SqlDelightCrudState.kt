package kotli.app.feature.showcases.presentation.dataflow.sqldelight.crud

import androidx.compose.runtime.Stable
import kotli.app.common.data.source.database.sqldelight.User

@Stable
interface SqlDelightCrudState {

    val users: List<User>

}