package shared.core.navigation

import androidx.compose.runtime.Composable

fun interface NavigationContentProvider<D> {

    @Composable
    fun provide(data: D?)

}