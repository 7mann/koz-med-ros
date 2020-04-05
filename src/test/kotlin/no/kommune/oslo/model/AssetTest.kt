package no.kommune.oslo.model

import no.kommune.oslo.model.AssetValueTypes.*
import no.kommune.oslo.model.SeverityLevels.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class AssetTest {

    @Test
    fun `Throws exception when getSeverityLevel is called with illegal arguments`() {
        assertFailsWith<IllegalArgumentException> {
            Asset("Bla", listOf(AssetValue(CONFIDENCIALITYVALUE, MODERATE), AssetValue(INTEGRITYVALUE, MODERATE)))
        }
    }

    @Test
    fun `Expect asset value with highest score is returned`() {
        val anAsset = Asset("Surename", listOf(
                AssetValue(CONFIDENCIALITYVALUE, MODERATE),
                AssetValue(INTEGRITYVALUE, HIGH),
                AssetValue(AVAILABILITYVALUE, EXTREME)
        ))
        val assetValue = anAsset.getAssetValue()
        assertThat(assetValue.assetValueType).isEqualTo(AVAILABILITYVALUE)
        assertThat(assetValue.severityLevel).isEqualTo(EXTREME)
    }
}