## Overview

- Component package: `app.theme.toggle`
- Integration config: `app.theme.ThemeConfig`

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