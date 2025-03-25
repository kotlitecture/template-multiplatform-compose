## Overview

- Component package: `app.theme.change`
- DI integration: `app.di.ThemeModule`

## Example

### As a separate screen

```kotlin
@Composable
fun App() {
    val navController = rememberNavController()
    
    LaunchEffect(Unit) {
        navController.navigate(ChangeThemeRoute)
    }
}

OR

@Composable
fun App() {
    val navController = rememberNavController()
    ChangeThemeScreen(
        onBack = navController::back
    )
}
```

### As a dialog

```kotlin
@Composable
fun App() {
    val navController = rememberNavController()

    LaunchEffect(Unit) {
        navController.navigate(ChangeThemeDialogRoute)
    }
}

OR

@Composable
fun App() {
    ChangeThemeDialog()
}
```