package no.kommune.oslo.model

import org.apache.logging.log4j.LogManager
import org.junit.jupiter.api.Test

internal class FileThreatLibraryRepositoryTest {
    private val logger = LogManager.getLogger(javaClass)
    private val env: MutableMap<String, String> = System.getenv()
    private val testPath = "${env["PWD"]}"
    private val testFileName = "riskScenarioTestFile.json"

    @Test
    fun readThreatAgents() {
        val testFilePath = "$testPath/src/main/resources"
        val testFile = "threatagents.json"
        logger.debug("testFilePath: $testFilePath")
        val threatLibraryRepo = FileThreatLibraryRepository(testFilePath, testFile)
        val threatAgentList = threatLibraryRepo.readThreatAgents()
        logger.debug(threatAgentList)
    }

    @Test
    fun writeThreatAgents() {
    }
}