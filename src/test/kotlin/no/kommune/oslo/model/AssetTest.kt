package no.kommune.oslo.model

import no.kommune.oslo.model.AssetValueTypes.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class AssetTest {

    @Test
    fun Throws_exception_when_getSeverityLevel_is_called_with_illegal_arguments() {
        assertFailsWith<IllegalArgumentException> {
            Asset("Bla", listOf(AssetValue(CONFIDENCIALITYVALUE, 3), AssetValue(INTEGRITYVALUE, 4)))
        }

    }

    @Test
    fun getAssetValues() {
    }
}