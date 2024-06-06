# Usage

## Overview

Component package: `app.feature.theme.toggle`

## Example

Simply add the `ToggleThemeButton` composable from the `app.feature.theme.toggle` package to your screen.

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
