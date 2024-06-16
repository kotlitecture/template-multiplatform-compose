package kotli.app

import android.app.Application as AndroidApplication

/**
 * Application class for the app.
 */
class Application : AndroidApplication() {

    override fun onCreate() {
        instance = this
        super.onCreate()
    }

    companion object {
        lateinit var instance: Application
    }

}