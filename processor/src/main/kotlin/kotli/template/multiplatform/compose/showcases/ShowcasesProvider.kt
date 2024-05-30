package kotli.template.multiplatform.compose.showcases

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes
import kotli.template.multiplatform.compose.showcases.datasource.http.HttpShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.datasource.keyvalue.KeyValueShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.datasource.paging.PagingShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.navigation.NavigationShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.feature.loader.data.DataLoaderShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.feature.passcode.PasscodeShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.feature.theme.ThemeShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.feature.theme.change.ChangeThemeShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.feature.theme.toggle.ToggleThemeShowcasesProcessor

object ShowcasesProvider : BaseFeatureProvider() {

    override fun getId(): String = "showcases"
    override fun getType(): FeatureType = FeatureTypes.Examples

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        ShowcasesProcessor::class.java
    )

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        ShowcasesProcessor,
        ThemeShowcasesProcessor,
        ChangeThemeShowcasesProcessor,
        ToggleThemeShowcasesProcessor,
        NavigationShowcasesProcessor,
        PasscodeShowcasesProcessor,
        PagingShowcasesProcessor,
        HttpShowcasesProcessor,
        KeyValueShowcasesProcessor,
        DataLoaderShowcasesProcessor
    )

}