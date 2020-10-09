package no.kommune.oslo.kozmedros.model

import no.kommune.oslo.kozmedros.model.enums.SeverityLevel
import no.kommune.oslo.kozmedros.model.enums.SeverityLevel.Companion

data class DiscreteThreatPresence(
        val isPresent: Boolean,
        val hasCapacity: Boolean,
        val hasIntention: Boolean,
        val hasHistory: Boolean,
        val isTarget: Boolean
) : ThreatPresence {

    override fun getSeverityLevel(): SeverityLevel {
        var numberOfArgumentsTrue = 0
        if (isPresent) numberOfArgumentsTrue += 1
        if (hasCapacity) numberOfArgumentsTrue += 1
        if (hasIntention) numberOfArgumentsTrue += 1
        if (hasHistory) numberOfArgumentsTrue += 1
        if (isTarget) numberOfArgumentsTrue += 1
        return Companion.getByValue(numberOfArgumentsTrue * 100)
//        val result = when (numberOfArgumentsTrue) {
//            0 -> NONE
//            1 -> INSIGNIFICANT
//            2 -> LOW
//            3 -> AVERAGE
//            4 -> HIGH
//            5 -> EXTREME
//            else -> INVALID
//        }
//        return result
    }

    override fun getThreatPresenceParameters(): Map<String, String> {
        return mapOf(
                "isPresent" to isPresent.toString(),
                "hasCapacity" to hasCapacity.toString(),
                "hasIntention" to hasIntention.toString(),
                "hasHistory" to hasHistory.toString(),
                "isTarget" to isTarget.toString()
        )
    }
}