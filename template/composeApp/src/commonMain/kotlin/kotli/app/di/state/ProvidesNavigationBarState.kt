package kotli.app.di.state

import androidx.compose.runtime.Composable
import kotli.app.feature.navigation.NavigationBarPage
import kotli.app.feature.navigation.NavigationBarState
import kotli.app.feature.navigation.samples.a.NavigationADestination
import kotli.app.feature.navigation.samples.b.NavigationBDestination
import kotli.app.feature.navigation.samples.c.NavigationCDestination
import kotli.app.showcases.ShowcasesDestination
import org.koin.dsl.module
import shared.core.navigation.NavigationDestination
import shared.core.navigation.NavigationState
import shared.core.navigation.NavigationStrategy
import template.composeapp.generated.resources.Res
import template.composeapp.generated.resources.ic_nav_coffee
import template.composeapp.generated.resources.ic_nav_local_bar
import template.composeapp.generated.resources.ic_nav_school
import template.composeapp.generated.resources.ic_nav_wine_bar

val ProvidesNavigationBarState = module {
    single {
        NavigationBarState(
            pages = listOf(
                // start {showcases}
                createPage(
                    navigationState = get(),
                    destination = ShowcasesDestination,
                    getActiveIcon = { Res.drawable.ic_nav_school },
                    getInactiveIcon = { Res.drawable.ic_nav_school },
                    getLabel = { "Showcases" }
                ),
                // end {showcases}
                createPage(
                    navigationState = get(),
                    destination = NavigationADestination,
                    getActiveIcon = { Res.drawable.ic_nav_wine_bar },
                    getInactiveIcon = { Res.drawable.ic_nav_wine_bar },
                    getLabel = { "Page 1" }
                ),
                createPage(
                    navigationState = get(),
                    destination = NavigationBDestination,
                    getActiveIcon = { Res.drawable.ic_nav_local_bar },
                    getInactiveIcon = { Res.drawable.ic_nav_local_bar },
                    getLabel = { "Page 2" }
                ),
                createPage(
                    navigationState = get(),
                    destination = NavigationCDestination,
                    getActiveIcon = { Res.drawable.ic_nav_coffee },
                    getInactiveIcon = { Res.drawable.ic_nav_coffee },
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