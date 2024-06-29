package shared.presentation.misc

/**
 * Returns the receiver if it is correct array index (it's greater than or equal to 0, otherwise returns null).
 */
fun Int.ifIndex(): Int? = this.takeIf { it >= 0 }