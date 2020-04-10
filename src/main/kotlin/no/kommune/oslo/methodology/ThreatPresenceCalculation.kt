package no.kommune.oslo.methodology

import no.kommune.oslo.model.SeverityLevels

interface ThreatPresenceCalculation {
    val threatPresenceValue: SeverityLevels
}