package no.kommune.oslo.kozmedros.model

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
    fun testKotlin() {
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

    @Test
    fun testReturnProperties() {
        val gt = GenTest()
        print(gt.returnList())
//        val dtp = DiscreteThreatPresence(true, false, true, false, true)
//
//        print(dtp.javaClass.kotlin.memberProperties)
//
//        dtp::class.memberProperties.forEach { member ->
//            println("${member.name} -> ${member.get()}")
//        }
//        val example = Example(field1 = "abc", field2 = 1, baseField = "someText")
//
//        example::class.memberProperties.forEach { member ->
//            println("${member.name} -> ${member.get(example as Nothing)}")
//        }
    }

    open class BaseExample(val baseField: String)

    class Example(val field1: String, val field2: Int, baseField: String) :
            BaseExample(baseField) {

        val field3: String
            get() = "Property without backing field"

        val field4 by lazy { "Delegated value" }

        val privateField: String = "Private value"
    }

    class GenTest() : genTestIF<Boolean, String> {
        override fun returnList(): List<String> {
            val list = listOf<String>("a", "b")
            return list
        }

        override fun returnMap(): Map<Boolean, String> {
            TODO("Not yet implemented")
        }
    }

    interface genTestIF<E, out F> {
        fun returnList(): List<F>
        fun returnMap(): Map<E, F>
    }
}