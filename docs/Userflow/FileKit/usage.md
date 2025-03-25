# Usage

## Overview

**Component**: `shared.presentation.ui.component.AppFilePicker`  
**Showcases**: `app.showcases.presentation.userflow.component.filepicker`

The component provides a general facade to abstract the underlying framework, allowing for easier replacement or modification in the future.

## Example

```kotlin
@Composable
fun AppFilePickerUsage() {
    val filePicker = getFileLauncher(onResult = { files ->
        // process the selected files
    })
    AppElevatedButton(text = "Select files", onClick = filePicker::launch)

    val imagesPicker = getImageLauncher(onResult = { images ->
        // process the selected images
    })
    AppElevatedButton(text = "Select images", onClick = imagesPicker::launch)

    val videoPicker = getVideoLauncher(onResult = { videos ->
        // process the selected videos
    })
    AppElevatedButton(text = "Select videos", onClick = videoPicker::launch)

    val mediaPicker = getMediaLauncher(onResult = { media ->
        // process the selected media
    })
    AppElevatedButton(text = "Select media", onClick = mediaPicker::launch)
}
```
