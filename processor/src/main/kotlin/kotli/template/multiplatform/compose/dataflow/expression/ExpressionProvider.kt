package kotli.template.multiplatform.compose.dataflow.expression

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.dataflow.BaseDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.expression.basic.BasicExpressionProcessor

object ExpressionProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.expression"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        BasicExpressionProcessor,
    )
}