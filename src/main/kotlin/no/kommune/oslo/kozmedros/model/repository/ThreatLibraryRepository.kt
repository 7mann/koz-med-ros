package no.kommune.oslo.kozmedros.model.repository

import no.kommune.oslo.kozmedros.model.Threat
import no.kommune.oslo.kozmedros.model.ThreatAgent
import no.kommune.oslo.kozmedros.model.Vulnerability

interface ThreatLibraryRepository {
    fun readThreatAgents(): List<ThreatAgent>
    fun writeThreatAgents(threatAgents: List<ThreatAgent>)
    fun readThreats(): List<Threat>
    fun writeThreats(threats: List<Threat>)
    fun readVulnerabilites(): List<Vulnerability>
    fun writeVulnerabilites(vulnerabilities: List<Vulnerability>)
}