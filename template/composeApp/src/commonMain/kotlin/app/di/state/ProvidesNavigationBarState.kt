package app.di.state

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.WineBar
import androidx.compose.material.icons.outlined.Coffee
import androidx.compose.material.icons.outlined.LocalDrink
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.WineBar
import androidx.compose.runtime.Composable
import app.showcases.ShowcasesDestination
import app.userflow.navigation.NavigationBarPage
import app.userflow.navigation.NavigationBarState
import app.userflow.navigation.samples.a.NavigationADestination
import app.userflow.navigation.samples.b.NavigationBDestination
import app.userflow.navigation.samples.c.NavigationCDestination
import core.ui.navigation.NavigationDestination
import core.ui.navigation.NavigationState
import core.ui.navigation.NavigationStrategy
import org.koin.dsl.module

val ProvidesNavigationBarState = module {
    single {
        NavigationBarState(
            pages = listOf(
                // start {showcases.common}
                createPage(
                    navigationState = get(),
                    destination = ShowcasesDestination,
                    getActiveIcon = { Icons.Filled.School },
                    getInactiveIcon = { Icons.Outlined.School },
                    getLabel = { "Showcases" }
                ),
                // end {showcases.common}
                createPage(
                    navigationState = get(),
                    destination = NavigationADestination,
                    getActiveIcon = { Icons.Filled.WineBar },
                    getInactiveIcon = { Icons.Outlined.WineBar },
                    getLabel = { "Page 1" }
                ),
                createPage(
                    navigationState = get(),
                    destination = NavigationBDestination,
                    getActiveIcon = { Icons.Filled.LocalDrink },
                    getInactiveIcon = { Icons.Outlined.LocalDrink },
                    getLabel = { "Page 2" }
                ),
                createPage(
                    navigationState = get(),
                    destination = NavigationCDestination,
                    getActiveIcon = { Icons.Filled.Coffee },
                    getInactiveIcon = { Icons.Outlined.Coffee },
                    getLabel = { "Page 3" }
                )
            ),
            allowedDestinations = setOf(
            ),
            restrictedDestinations = setOf(
            )
        )
    }
}

private fun <D> createPage(
    navigationState: NavigationState,
    destination: NavigationDestination<D>,
    getInactiveIcon: () -> Any,
    getActiveIcon: () -> Any,
    getLabel: @Composable () -> String?,
): NavigationBarPage {
    return NavigationBarPage(
        enabled = true,
        id = destination.id,
        getLabel = getLabel,
        alwaysShowLabel = false,
        getActiveIcon = getActiveIcon,
        getInactiveIcon = getInactiveIcon,
        onClick = { navigate(navigationState, destination) }
    )
}

private fun <D> navigate(
    navigationState: NavigationState,
    destination: NavigationDestination<D>
) {
    navigationState.onNext(
        destination = destination,
        strategy = NavigationStrategy.SingleInstance
    )
}