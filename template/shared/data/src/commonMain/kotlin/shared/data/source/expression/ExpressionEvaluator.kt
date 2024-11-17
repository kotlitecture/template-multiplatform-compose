package shared.data.source.expression

import shared.data.source.DataSource

interface ExpressionEvaluator : DataSource {

    fun evalDouble(expression: String, args: Map<String, Any> = emptyMap()): Double

    fun evalBoolean(expression: String, args: Map<String, Any> = emptyMap()): Boolean
}