# Usage

## Overview

- Component package: `app.theme`
- State management: `shared.presentation.theme.ThemeState`
- DI integration: `app.theme.ThemeConfig`

This state instance is utilized by `app.theme.provide.presentation.ThemeProvider`, which is pre-defined at the app level to furnish themes for the entire application.

```kotlin
@Composable
fun App() = ViewModelProvider({ app() }) {
    ThemeProvider {
        AppScreen()
    }
}
```

## Change Themes

By default, `ThemeState` is initialized with pre-defined dark and light themes in the `presentation` module. To edit these themes:

1. Visit the [Material 3 Theme Builder](https://m3.material.io/theme-builder#/custom).
2. Customize the desired color theme.
3. Click on the **Export** button and confirm exporting as **Jetpack Compose (Theme.kt)**.
4. Paste the exported files (**Theme.kt** and **Color.kt**) into the package `shared.presentation.theme.m3` of the `presentation` module and update their package declaration accordingly.
5. In the `Themes.kt` file add the following snippet:
   ```kotlin
   object Themes {
      val Light = Theme(
          dark = false,
          id = "material_3_light",
          colorScheme = lightScheme
      )

      val Dark = Theme(
          dark = true,
          id = "material_3_dark",
          colorScheme = darkScheme
      )
   }
   ```

The themes can be declared directly in the app module. However, if you plan to use feature modules, it might be beneficial to declare the theme in the `presentation` module.
