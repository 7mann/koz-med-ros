package no.kommune.oslo.kozmedros.model

import no.kommune.oslo.kozmedros.model.enums.RiskType.PERSONAL_DATA
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RiskScenarioTest {

    @Test
    fun `test HashCode and Equals`() {
        val rs1 = RiskScenario(PERSONAL_DATA, "Test scenario 1")
        val rs2 = RiskScenario(PERSONAL_DATA, "Test scenario 1")
        val rs3 = RiskScenario(PERSONAL_DATA, "Test scenario 2")
        val rs1copy = rs1.copy()

        assertThat(rs1).isEqualTo(rs2)
        assertThat(rs1.equals(rs2)).isTrue()
        assertThat(rs1.hashCode()).isEqualTo(rs2.hashCode())
        assertThat(rs1).isEqualTo(rs1copy)
        assertThat(rs1.equals(rs1copy)).isTrue()
        assertThat(rs1.hashCode()).isEqualTo(rs1copy.hashCode())
        assertThat(rs1).isNotEqualTo(rs3)
        assertThat(rs1.equals(rs3)).isFalse()
        assertThat(rs1.hashCode()).isNotEqualTo(rs3.hashCode())
    }
}