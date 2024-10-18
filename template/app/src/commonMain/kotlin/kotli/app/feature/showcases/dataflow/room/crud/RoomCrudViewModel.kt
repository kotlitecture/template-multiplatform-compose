package kotli.app.feature.showcases.dataflow.room.crud

import kotli.app.feature.showcases.dataflow.room.crud.model.UserData
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel

abstract class RoomCrudViewModel(val navigationStore: NavigationStore) : BaseViewModel() {

    val usersState = DataState<List<UserData>>(emptyList())

    fun onBack() = navigationStore.onBack()

    abstract fun onAdd()

    abstract fun onDelete(user: UserData)
}
