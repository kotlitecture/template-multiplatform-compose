package shared.presentation.misc.extensions

import android.content.Context
import android.content.ContextWrapper
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