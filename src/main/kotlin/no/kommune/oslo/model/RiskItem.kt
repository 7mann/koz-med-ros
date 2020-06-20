package no.kommune.oslo.model

import no.kommune.oslo.model.enums.SeverityLevel

interface RiskItem {
    fun getSeverityLevel(): SeverityLevel
}
