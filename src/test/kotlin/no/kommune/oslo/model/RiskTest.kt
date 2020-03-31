package no.kommune.oslo.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RiskTest {

    @Test
    fun getNbr() {
//        val r1 = Risk(5, "My Description")
//        println("Risk number: ${r1.id}")
//        assertThat(r1.id).isEqualTo(5)
    }

    @Test
    fun getDescription() {
    }

    @Test
    fun testKotlin(){
//        fun <T, R> Collection<T>.fold(
//            initial: R,
//            combine: (acc: R, nextElement: T) -> R
//        ): R {
//            var accumulator: R = initial
//            for (element: T in this) {
//                accumulator = combine(accumulator, element)
//            }
//            return accumulator
//        }
        val items = listOf(1, 2, 3, 4, 5)

        // Lambdas are code blocks enclosed in curly braces.
        items.fold(0, {
            // When a lambda has parameters, they go first, followed by '->'
                acc: Int, i: Int ->
            print("acc = $acc, i = $i, ")
            val result = acc + i
            println("result = $result")
            // The last expression in a lambda is considered the return value:
            result
        })
    }
}