package kotli.app.di.state

import kotli.app.showcases.ShowcasesDestination
import kotli.app.ui.screen.template.TemplateDestination
import kotli.app.ui.screen.template_no_args.TemplateNoArgsDestination
import kotli.app.userflow.navigation.samples.a.NavigationADestination
import kotli.app.userflow.navigation.samples.b.NavigationBDestination
import kotli.app.userflow.navigation.samples.c.NavigationCDestination
import kotli.app.userflow.theme.change.ChangeThemeDestination
import kotli.app.userflow.theme.change.ChangeThemeDialogDestination
import org.koin.dsl.module
import shared.core.navigation.NavigationState

val ProvidesNavigationState = module {
    single {
        NavigationState(
            destinations = listOf(
                ShowcasesDestination,
                TemplateDestination,
                TemplateNoArgsDestination,
                ChangeThemeDestination,
                ChangeThemeDialogDestination,
                NavigationADestination,
                NavigationBDestination,
                NavigationCDestination,
            )
        )
    }
}