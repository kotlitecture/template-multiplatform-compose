package core.ui.misc.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.content.ContextWrapper
import android.os.Vibrator
import androidx.activity.ComponentActivity

/**
 * Finds the nearest FragmentActivity from the given Context.
 *
 * @return The nearest FragmentActivity, or null if not found.
 */
fun Context.findActivity(): ComponentActivity? {
    if (this is ComponentActivity) return this
    var context = this
    while (context is ContextWrapper) {
        if (context is ComponentActivity) return context
        context = context.baseContext
    }
    return null
}

fun Context.vibrateHaptic() = vibrate(longArrayOf(0, 10))
fun Context.vibrateOk() = vibrate(longArrayOf(0, 20))
fun Context.vibrateWrong() = vibrate(longArrayOf(0, 40, 100, 40))

@SuppressLint("MissingPermission")
private fun Context.vibrate(pattern: LongArray, repeatMode: Int = -1): Boolean {
    return try {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        vibrator?.run {
            vibrate(pattern, repeatMode)
            true
        } ?: run { false }
    } catch (th: Throwable) {
        false
    }
}