package no.kommune.oslo.model

import org.apache.logging.log4j.LogManager

class FileThreatLibraryRepository(val path: String, val fileName: String) : FileLibraryRepository(), ThreatLibraryRepository {
    private val logger = LogManager.getLogger(javaClass)
    private val fileNameAndPath: String

    init {
        if (path.isBlank()) {
            throw IllegalArgumentException("Path must be present!")
        }
        if (fileName.isBlank()) {
            throw IllegalArgumentException("File name must be present!")
        }
        this.fileNameAndPath = "$path/$fileName"
    }

    override fun readThreatAgents(): List<ThreatAgent> {
        return this.readJsonFile<ThreatAgent>(this.fileNameAndPath)
    }

    override fun writeThreatAgents(threatAgents: List<ThreatAgent>) {
        if (threatAgents.isNullOrEmpty()) {
            throw IllegalArgumentException("ThreatAgent list can not be null or empty!")
        }
        this.writeJsonFile<ThreatAgent>(threatAgents, fileNameAndPath)
    }
}