## Overview

- Component package: `app.navigation`

## Configuration

Register all required destinations using `app.navigation.NavigationConfig`.

```kotlin
fun NavGraphBuilder.navigation(navController: NavHostController) {
    composable<ARoute> { AScreen() }
    composable<BRoute> { BScreen() }
    composable<CRoute> { CScreen() }
}

fun InitializerViewModelFactoryBuilder.navigation() {
    initializer { AViewModel() }
    initializer { BViewModel() }
    initializer { CViewModel() }
    initializer { NavigationViewModel() }
}
```

Configure your navigation items using `app.navigation.provide.presentation.NavigationViewModel`.

```kotlin
class NavigationViewModel : BaseViewModel() {
    ...
    private fun createItems(onRoute: (route: Any) -> Unit) = listOf(
        createItem(
            route = ARoute,
            onRoute = onRoute,
            label = "Page A",
            activeIcon = DsIcons.wineBar,
            inactiveIcon = DsIcons.wineBar,
        ),
        createItem(
            route = BRoute,
            onRoute = onRoute,
            label = "Page B",
            activeIcon = DsIcons.localDrink,
            inactiveIcon = DsIcons.localDrink,
        ),
        createItem(
            route = CRoute,
            onRoute = onRoute,
            label = "Page C",
            activeIcon = DsIcons.coffee,
            inactiveIcon = DsIcons.coffee,
        )
    )
    ...
}
```