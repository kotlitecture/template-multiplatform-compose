package shared

import com.github.murzagalin.evaluator.Evaluator
import kotlin.test.Test

class EvaluatorTest {

    @Test
    fun testA() {
        val evaluator = Evaluator()

        println(evaluator.evaluateDouble("23 + 0.123 * (124 / -60.124)"))

        val expression = evaluator.preprocessExpression("(x + y) + (z * 2)")

        println(
            evaluator.evaluateDouble(
                expression,
                mapOf(
                    "x" to 1,
                    "y" to 2,
                    "z" to 3
                )
            )
        )
    }
}