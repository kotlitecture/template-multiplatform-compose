## Overview

Component package: `app.userflow.theme.toggle`

## Example

Simply add the `ToggleThemeButton` composable from the `app.userflow.theme.toggle` package to your screen.

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