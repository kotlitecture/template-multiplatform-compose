package kotli.app.showcases.presentation.userflow.theme.change

import kotli.app.showcases.domain.Showcase
import kotli.app.theme.change.presentation.ChangeThemeDialogRoute
import kotli.app.theme.change.presentation.ChangeThemeRoute

object ChangeThemeShowcases {

    val dialog = Showcase.Screen("Change Theme Dialog", ChangeThemeDialogRoute)
    val screen = Showcase.Screen("Change Theme Screen", ChangeThemeRoute)
}