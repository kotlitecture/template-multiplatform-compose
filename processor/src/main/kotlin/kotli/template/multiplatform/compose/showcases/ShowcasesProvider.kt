package kotli.template.multiplatform.compose.showcases

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes
import kotli.template.multiplatform.compose.showcases.dataflow.ai.GeminiShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.dataflow.cache.CacheShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.dataflow.database.room.RoomShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.dataflow.database.sqldelight.SqlDelightShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.dataflow.encryption.EncryptionShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.dataflow.http.HttpShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.dataflow.keyvalue.KeyValueShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.dataflow.paging.PagingShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.component.ComponentShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.component.filepicker.FilePickerShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.component.image.CoilShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.component.markdown.MarkdownShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.component.placeholder.PlaceholderShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.loader.data.DataLoaderShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.passcode.PasscodeShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.theme.ThemeShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.theme.change.ChangeThemeShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.theme.toggle.ToggleThemeShowcasesProcessor

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
        PasscodeShowcasesProcessor,
        PagingShowcasesProcessor,
        HttpShowcasesProcessor,
        KeyValueShowcasesProcessor,
        DataLoaderShowcasesProcessor,
        CacheShowcasesProcessor,
        RoomShowcasesProcessor,
        SqlDelightShowcasesProcessor,
        EncryptionShowcasesProcessor,
        ComponentShowcasesProcessor,
        FilePickerShowcasesProcessor,
        CoilShowcasesProcessor,
        MarkdownShowcasesProcessor,
        PlaceholderShowcasesProcessor,
        GeminiShowcasesProcessor
    )

}