# Usage

## Overview

Component: `shared.design.component.AppPlaceholder`

The usage guide is best described in the official component [documentation](https://github.com/eygraber/compose-placeholder).

The inclusion of this component adds the dependency on this component and provides some general examples of how it can be used.

## Example

```kotlin
val loading = true // usually, some dynamically updated value (viewModel.loadingState.asStateValueNotNull())

AppElevatedButton(modifier = Modifier.withPlaceholder(loading, cornerRadius = 16.dp))

AppTextField(modifier = Modifier.withPlaceholder(loading, cornerRadius = 8.dp))

...
```
