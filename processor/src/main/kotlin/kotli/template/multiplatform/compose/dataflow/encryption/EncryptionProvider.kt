package kotli.template.multiplatform.compose.dataflow.encryption

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.dataflow.BaseDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.encryption.korlibs.KorlibsEncryptionProcessor
import kotli.template.multiplatform.compose.showcases.dataflow.encryption.EncryptionShowcasesProcessor

object EncryptionProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.encryption"

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        EncryptionShowcasesProcessor::class.java
    )

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        KorlibsEncryptionProcessor,
    )
}