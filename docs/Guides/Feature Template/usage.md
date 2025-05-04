# Usage

## Overview

- Component package: `app.template.feature`
- Integration config: `app.template.feature.TemplateConfig`

The template is organized into three main layers following Clean Architecture:

- **Data Layer (`data`)**: Manages data sources, API calls, and data models.
- **Domain Layer (`domain`)**: Contains business logic, use cases, and interfaces.
- **Presentation Layer (`presentation`)**: Houses UI components, ViewModels, state management, and UI logic.

This setup encourages modular, testable, and maintainable code, adhering to MVVM and UDF standards.

## How to use

1. Duplicate the package `app.template.feature` and rename it to your feature's name, e.g., `profile`, `settings`, etc.
2. Register newly copied `TemplateConfig.kt` in the `AppConfig.kt`.
3. Access your feature screen from `navController` where it is required:
   ```kotlin
   fun NavGraphBuilder.someFeature(navController: NavHostController) {
       composable<SomeScreen> {
            SomeScreen(
                onShowMyNewFeature = {
                    val route = TemplateRoute("My template screen")
                    navController.newInstance(route)
                }
            )
        }
   }
    ```
