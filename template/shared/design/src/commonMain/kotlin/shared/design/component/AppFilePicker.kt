package shared.design.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import io.github.vinceglb.filekit.compose.rememberFilePickerLauncher
import io.github.vinceglb.filekit.core.PickerMode
import io.github.vinceglb.filekit.core.PickerType
import io.github.vinceglb.filekit.core.PlatformFile
import io.github.vinceglb.filekit.core.PlatformFiles

private const val MAX_FILES = 50

data class AppFilePickerFile(
    val name: String,
    val path: String?,
    val getSize: () -> Long?,
    val readBytes: suspend () -> ByteArray,
)

fun interface AppFilePickerLauncher {
    fun launch()
}

@Composable
fun getFileLauncher(
    maxFiles: Int = MAX_FILES,
    title: String? = null,
    extensions: List<String>? = null,
    onResult: (files: List<AppFilePickerFile>) -> Unit
): AppFilePickerLauncher {
    return getLauncher(
        type = PickerType.File(extensions),
        maxFiles = maxFiles,
        onResult = onResult,
        title = title,
    )
}

@Composable
fun getImageLauncher(
    maxFiles: Int = MAX_FILES,
    title: String? = null,
    onResult: (files: List<AppFilePickerFile>) -> Unit
): AppFilePickerLauncher {
    return getLauncher(
        type = PickerType.Image,
        maxFiles = maxFiles,
        onResult = onResult,
        title = title,
    )
}

@Composable
fun getVideoLauncher(
    maxFiles: Int = MAX_FILES,
    title: String? = null,
    onResult: (files: List<AppFilePickerFile>) -> Unit
): AppFilePickerLauncher {
    return getLauncher(
        type = PickerType.Video,
        maxFiles = maxFiles,
        onResult = onResult,
        title = title,
    )
}

@Composable
fun getMediaLauncher(
    maxFiles: Int = MAX_FILES,
    title: String? = null,
    onResult: (files: List<AppFilePickerFile>) -> Unit
): AppFilePickerLauncher {
    return getLauncher(
        type = PickerType.ImageAndVideo,
        maxFiles = maxFiles,
        onResult = onResult,
        title = title,
    )
}

private fun PlatformFile.toAppFile() = AppFilePickerFile(
    name = name,
    path = path,
    getSize = this::getSize,
    readBytes = this::readBytes
)

@Composable
private fun getLauncher(
    maxFiles: Int = MAX_FILES,
    title: String? = null,
    type: PickerType = PickerType.File(),
    mode: PickerMode<PlatformFiles> = PickerMode.Multiple(maxFiles),
    onResult: (files: List<AppFilePickerFile>) -> Unit
): AppFilePickerLauncher {
    val launcher = rememberFilePickerLauncher(title = title, mode = mode, type = type) { files ->
        val appFiles = files
            ?.take(maxFiles)
            ?.map { file -> file.toAppFile() } ?: emptyList()
        onResult.invoke(appFiles)
    }

    return remember(launcher) {
        AppFilePickerLauncher {
            launcher.launch()
        }
    }
}