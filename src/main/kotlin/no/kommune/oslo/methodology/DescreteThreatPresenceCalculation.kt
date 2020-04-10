package no.kommune.oslo.methodology

import no.kommune.oslo.model.SeverityLevels
import no.kommune.oslo.model.SeverityLevels.*


data class DiscreetThreatPresenceCalculation(val isPresent: Boolean, val hasCapacity: Boolean, val hasIntention: Boolean, val hasHistory: Boolean, val isTarget: Boolean) : ThreatPresenceCalculation {
    override val threatPresenceValue: SeverityLevels
        get() {
            var numberOfArgumentsTrue = 0
            if (isPresent) numberOfArgumentsTrue += 1
            if (hasCapacity) numberOfArgumentsTrue += 1
            if (hasIntention) numberOfArgumentsTrue += 1
            if (hasHistory) numberOfArgumentsTrue += 1
            if (isTarget) numberOfArgumentsTrue += 1
            val result = when (numberOfArgumentsTrue) {
                0 -> NONE
                1 -> INSIGNIFICANT
                2 -> LOW
                3 -> MODERATE
                4 -> HIGH
                5 -> EXTREME
                else -> INVALID
            }
            return result
        }
}