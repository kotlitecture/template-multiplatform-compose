package kotli.app

import android.app.Application as AndroidApplication

class Application : AndroidApplication() {

    override fun onCreate() {
        instance = this
        super.onCreate()
    }

    companion object {
        lateinit var instance: Application
    }

}