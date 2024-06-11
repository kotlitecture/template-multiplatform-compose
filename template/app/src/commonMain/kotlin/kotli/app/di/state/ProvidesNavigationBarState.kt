package kotli.app.di.state

import androidx.compose.runtime.Composable
import kotli.app.feature.navigation.NavigationBarPage
import kotli.app.feature.navigation.NavigationBarState
import kotli.app.feature.navigation.samples.a.NavigationADestination
import kotli.app.feature.navigation.samples.b.NavigationBDestination
import kotli.app.feature.navigation.samples.c.NavigationCDestination
import kotli.app.showcases.ShowcasesDestination
import org.koin.dsl.module
import shared.presentation.navigation.NavigationDestination
import shared.presentation.navigation.NavigationState
import shared.presentation.navigation.NavigationStrategy
import shared.design.icon.AppIconModel
import shared.design.icon.AppIcons

val ProvidesNavigationBarState = module {
    single {
        NavigationBarState(
            pages = listOf(
                // start {showcases}
                createPage(
                    navigationState = get(),
                    destination = ShowcasesDestination,
                    getActiveIcon = { AppIcons.school },
                    getInactiveIcon = { AppIcons.school },
                    getLabel = { "Showcases" }
                ),
                // end {showcases}
                createPage(
                    navigationState = get(),
                    destination = NavigationADestination,
                    getActiveIcon = { AppIcons.wineBar },
                    getInactiveIcon = { AppIcons.wineBar },
                    getLabel = { "Page 1" }
                ),
                createPage(
                    navigationState = get(),
                    destination = NavigationBDestination,
                    getActiveIcon = { AppIcons.localDrink },
                    getInactiveIcon = { AppIcons.localDrink },
                    getLabel = { "Page 2" }
                ),
                createPage(
                    navigationState = get(),
                    destination = NavigationCDestination,
                    getActiveIcon = { AppIcons.coffee },
                    getInactiveIcon = { AppIcons.coffee },
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
    getInactiveIcon: () -> AppIconModel,
    getActiveIcon: () -> AppIconModel,
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