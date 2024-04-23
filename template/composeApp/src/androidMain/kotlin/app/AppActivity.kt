package app

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import app.di.koinGet
import core.ui.misc.extensions.findActivity
import core.ui.theme.ThemeState

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            App()
            EdgeToEdgeHandler(koinGet())
            SplashBlock(splashScreen)
        }
    }
}

@Composable
private fun EdgeToEdgeHandler(state: ThemeState) {
    val activity = LocalContext.current.findActivity() ?: return
    val data = state.dataStore.asStateValue() ?: return
    val barStyle = remember(data.dark) {
        if (data.dark) {
            SystemBarStyle.dark(Color.TRANSPARENT)
        } else {
            SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT)
        }
    }
    LaunchedEffect(data) {
        activity.enableEdgeToEdge(
            statusBarStyle = barStyle,
            navigationBarStyle = barStyle
        )
    }
}

@Composable
private fun SplashBlock(splashScreen: SplashScreen) {
    splashScreen.setKeepOnScreenCondition { false }
}