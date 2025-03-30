package kotli.app.showcases.presentation.dataflow.sqldelight.crud

import androidx.compose.runtime.Stable
import kotli.app.common.data.source.database.UserEntity

@Stable
interface SqlDelightCrudState {

    val users: List<UserEntity>
}