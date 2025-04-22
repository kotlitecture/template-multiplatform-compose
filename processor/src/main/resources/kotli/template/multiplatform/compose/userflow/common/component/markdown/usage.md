## Overview

**Component**: `shared.presentation.ui.component.AppMarkdown`  
**Showcases**: `app.showcases.presentation.userflow.component.markdown`

The component provides a general facade to abstract the underlying framework, allowing for easier replacement or modification in the future.

## Example

```kotlin
@Composable
fun AppMarkdownUsage() {
    AppMarkdown(text = """
        # h1 Heading
        ## h2 Heading
        ### h3 Heading
        #### h4 Heading
        ##### h5 Heading
        ###### h6 Heading    
    """.trimIndent())
}
```