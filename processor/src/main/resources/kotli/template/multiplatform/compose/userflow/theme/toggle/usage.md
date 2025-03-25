## Overview

- Component package: `app.theme.toggle`
- DI integration: `app.di.ThemeModule`

## Example

Simply add the `ToggleThemeButton` composable from the `app.theme.toggle` package to your screen.

```kotlin
@Composable
fun TemplateScreen() {
    FixedTopBarColumnLayout(
        actions = {
            ToggleThemeButton()
        },
        content = {
            //
        }
    )
}
```