package shared.presentation.misc

fun Int.ifIndex(): Int? = this.takeIf { it >= 0 }