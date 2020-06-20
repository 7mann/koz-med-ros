package no.kommune.oslo.model.repository

import no.kommune.oslo.model.Threat
import no.kommune.oslo.model.ThreatAgent

interface ThreatLibraryRepository {
    fun readThreatAgents(): List<ThreatAgent>
    fun writeThreatAgents(threatAgents: List<ThreatAgent>)
    fun readThreat(): List<Threat>
    fun writeThreat(threats: List<Threat>)
}