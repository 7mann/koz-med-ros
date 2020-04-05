package no.kommune.oslo.methodology

import no.kommune.oslo.model.Asset
import no.kommune.oslo.model.Threat

interface RiskCalculationStrategy {
    fun calculateDamagePotential(assets: List<Asset>): Int
    fun calculateThreatPresence(threats: List<Threat>): Int
}