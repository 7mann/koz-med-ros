package no.kommune.oslo.model

import no.kommune.oslo.model.SeverityLevels.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SeverityLevelsTest {
    @Test
    fun `Expect correct SeverityLevelEnum returned using Int-values`() {
        assertThat(SeverityLevels.getByValue(NONE.severityLevelValue)).isEqualTo(NONE)
        assertThat(SeverityLevels.getByValue(LOW.severityLevelValue)).isEqualTo(LOW)
        assertThat(SeverityLevels.getByValue(MODERATE.severityLevelValue)).isEqualTo(MODERATE)
        assertThat(SeverityLevels.getByValue(HIGH.severityLevelValue)).isEqualTo(HIGH)
        assertThat(SeverityLevels.getByValue(EXTREME.severityLevelValue)).isEqualTo(EXTREME)
    }

    @Test
    fun `Expect INVALID severity level returned when invalid number value entered`() {
        assertThat(SeverityLevels.getByValue(-1)).isEqualTo(INVALID)
        assertThat(SeverityLevels.getByValue(-2)).isEqualTo(INVALID)
        assertThat(SeverityLevels.getByValue(199)).isEqualTo(INVALID)
        assertThat(SeverityLevels.getByValue(Int.MAX_VALUE)).isEqualTo(INVALID)
    }
}