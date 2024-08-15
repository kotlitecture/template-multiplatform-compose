package kotli.template.multiplatform.compose.dataflow.encryption

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.dataflow.BaseDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.encryption.korlibs.KorlibsEncryptionProcessor

object EncryptionProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.encryption"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        KorlibsEncryptionProcessor
    )
}