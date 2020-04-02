package no.kommune.oslo.model

import no.kommune.oslo.model.AssetValueTypes.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith
import org.assertj.core.api.Assertions.*


internal class AssetTest {

    @Test
    fun `Throws exception when getSeverityLevel is called with illegal arguments`() {
        assertFailsWith<IllegalArgumentException> {
            Asset("Bla", listOf(AssetValue(CONFIDENCIALITYVALUE, 3), AssetValue(INTEGRITYVALUE, 4)))
        }

    }

    @Test
    fun `Expect asset value with highest score is returned`() {
        val anAsset = Asset("Surename", listOf(
                AssetValue(CONFIDENCIALITYVALUE, 3),
                AssetValue(INTEGRITYVALUE, 4),
                AssetValue(AVAILABILITYVALUE, 5)
        ))
        val assetValue = anAsset.getAssestValue()
        assertThat(assetValue.assetValueType).isEqualTo(AVAILABILITYVALUE)
        assertThat(assetValue.assetNumberValue).isEqualTo(5)
        println("Asset valuetype ${assetValue.assetValueType}, number value: ${assetValue.assetNumberValue}")

    }
}