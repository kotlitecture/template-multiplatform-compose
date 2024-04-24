package app.showcases

import app.showcases.theme.change.ChangeThemeDialogShowcase
import app.showcases.theme.change.ChangeThemeScreenShowcase
import app.showcases.theme.toggle.ToggleThemeShowcase

/**
 * Object containing all showcase items.
 */
object Showcases {

    /**
     * A list containing all showcase items.
     */
    val all = listOf(
        ShowcaseItemGroup("Userflow :: Theme"),
        ChangeThemeScreenShowcase,
        ChangeThemeDialogShowcase,
        ToggleThemeShowcase,
    )

}