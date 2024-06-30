# Usage

## Overview

Component package: `app.presentation.theme.toggle`

## Example

Simply add the `ToggleThemeButton` composable from the `app.presentation.theme.toggle` package to your screen.

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
