## Overview

- Component package: `app.theme`
- State management: `shared.presentation.theme.ThemeState`
- Integration config: `app.theme.ThemeConfig`

This state instance is utilized by `app.theme.provide.presentation.ThemeProvider`, which is pre-defined at the app level
to furnish themes for the entire application.

```kotlin
@Composable
fun App() = ViewModelProvider({ app() }) {
        ThemeProvider {
            AppScreen()
        }
    }
```

## Change Themes

By default, `ThemeState` is initialized with pre-defined dark and light themes in the `app.theme` package of `app`
module.

```kotlin
val theme = module {
    single<ThemeState> {
        DefaultThemeState(
            defaultConfig = ThemeConfig(
                defaultTheme = DsThemes.Light,
                lightTheme = DsThemes.Light,
                darkTheme = DsThemes.Dark,
            )
        )
    }
}
```

The themes itself are declared in `shared:presentation` module as part of the **design system**.

To edit these themes:

1. Visit the [Material 3 Theme Builder](https://m3.material.io/theme-builder#/custom).
2. Customize the desired color theme.
3. Click on the **Export** button and confirm exporting as **Jetpack Compose (Theme.kt)**.
4. Paste the exported files (**Theme.kt** and **Color.kt**) into the package `shared.presentation.ui.theme.m3` of the
   `shared:presentation` module and update their package declaration accordingly.
5. In the `shared.presentation.ui.theme.DsThemes` file add the following snippet:
   ```kotlin
   object DsThemes {
      val Light = DsTheme(
          dark = false,
          id = "light",
          colorScheme = lightScheme
      )

      val Dark = DsTheme(
          dark = true,
          id = "dark",
          colorScheme = darkScheme
      )
   }
   ```

The themes can be declared directly in the `app` module. However, if you plan to use feature modules, it might be
beneficial to declare the theme in the `shared:presentation` module.
