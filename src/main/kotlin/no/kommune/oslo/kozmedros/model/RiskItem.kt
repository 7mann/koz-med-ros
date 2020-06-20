package no.kommune.oslo.kozmedros.model

import no.kommune.oslo.kozmedros.model.enums.SeverityLevel

interface RiskItem {
    fun getSeverityLevel(): SeverityLevel
}
