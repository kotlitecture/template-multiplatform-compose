package app.di.state

import app.showcases.ShowcasesDestination
import app.ui.screen.template.TemplateDestination
import app.ui.screen.template_no_args.TemplateNoArgsDestination
import app.userflow.navigation.samples.a.NavigationADestination
import app.userflow.navigation.samples.b.NavigationBDestination
import app.userflow.navigation.samples.c.NavigationCDestination
import app.userflow.theme.change.ChangeThemeDestination
import app.userflow.theme.change.ChangeThemeDialogDestination
import shared.core.navigation.NavigationState
import org.koin.dsl.module

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