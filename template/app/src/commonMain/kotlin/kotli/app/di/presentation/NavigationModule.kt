package kotli.app.di.presentation

import kotli.app.presentation.showcases.ShowcasesDestination
import kotli.app.presentation.template.screen_with_args.TemplateDestination
import kotli.app.presentation.template.screen_without_args.TemplateNoArgsDestination
import kotli.app.presentation.navigation.samples.a.NavigationADestination
import kotli.app.presentation.navigation.samples.b.NavigationBDestination
import kotli.app.presentation.navigation.samples.c.NavigationCDestination
import kotli.app.presentation.theme.change.ChangeThemeDestination
import kotli.app.presentation.theme.change.ChangeThemeDialogDestination
import org.koin.dsl.module
import shared.presentation.navigation.NavigationStore

val navigationModule = module {
    single {
        NavigationStore(
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