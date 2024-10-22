package kotli.app.feature.showcases.presentation.userflow.theme.change

import kotli.app.feature.showcases.domain.Showcase
import kotli.app.feature.theme.change.presentation.ChangeThemeDialogRoute
import kotli.app.feature.theme.change.presentation.ChangeThemeRoute

object ChangeThemeShowcases {

    val dialog = Showcase.Screen("Change Theme Dialog", ChangeThemeDialogRoute)
    val screen = Showcase.Screen("Change Theme Screen", ChangeThemeRoute)

}