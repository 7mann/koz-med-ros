package no.kommune.oslo.kozmedros.model

import no.kommune.oslo.kozmedros.model.enums.SeverityLevel
import no.kommune.oslo.kozmedros.model.enums.SeverityLevel.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SeverityLevelsTest {
    @Test
    fun `Expect correct SeverityLevelEnum returned using Int-values`() {
        assertThat(SeverityLevel.getByValue(NONE.severityLevelValue)).isEqualTo(NONE)
        assertThat(SeverityLevel.getByValue(LOW.severityLevelValue)).isEqualTo(LOW)
        assertThat(SeverityLevel.getByValue(MODERATE.severityLevelValue)).isEqualTo(MODERATE)
        assertThat(SeverityLevel.getByValue(HIGH.severityLevelValue)).isEqualTo(HIGH)
        assertThat(SeverityLevel.getByValue(EXTREME.severityLevelValue)).isEqualTo(EXTREME)
    }

    @Test
    fun `Expect INVALID severity level returned when invalid number value entered`() {
        assertThat(SeverityLevel.getByValue(-1)).isEqualTo(INVALID)
        assertThat(SeverityLevel.getByValue(-2)).isEqualTo(INVALID)
        assertThat(SeverityLevel.getByValue(199)).isEqualTo(INVALID)
        assertThat(SeverityLevel.getByValue(Int.MAX_VALUE)).isEqualTo(INVALID)
    }
}