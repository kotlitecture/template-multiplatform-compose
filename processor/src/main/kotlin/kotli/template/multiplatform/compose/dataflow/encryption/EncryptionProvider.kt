package kotli.template.multiplatform.compose.dataflow.encryption

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.dataflow.BaseDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.encryption.korlibs.KorlibsEncryptionProcessor
import kotli.template.multiplatform.compose.showcases.dataflow.encryption.EncryptionShowcasesProcessor
import kotlin.reflect.KClass

object EncryptionProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.encryption"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        EncryptionShowcasesProcessor::class
    )

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        KorlibsEncryptionProcessor,
    )
}