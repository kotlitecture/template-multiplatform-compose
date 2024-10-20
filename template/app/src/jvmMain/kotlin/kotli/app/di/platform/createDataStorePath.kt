package kotli.app.di.platform

import java.io.File

actual fun createDataStorePath(fileName: String): String {
    val file = File(System.getProperty("java.io.tmpdir"), fileName)
    return file.absolutePath
}