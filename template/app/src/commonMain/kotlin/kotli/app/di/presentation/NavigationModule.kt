package kotli.app.di.presentation

import kotli.app.showcases.ShowcasesDestination
import kotli.app.ui.screen.template.TemplateDestination
import kotli.app.ui.screen.template_no_args.TemplateNoArgsDestination
import kotli.app.presentation.navigation.samples.a.NavigationADestination
import kotli.app.presentation.navigation.samples.b.NavigationBDestination
import kotli.app.presentation.navigation.samples.c.NavigationCDestination
import kotli.app.presentation.ui.theme.change.ChangeThemeDestination
import kotli.app.presentation.ui.theme.change.ChangeThemeDialogDestination
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