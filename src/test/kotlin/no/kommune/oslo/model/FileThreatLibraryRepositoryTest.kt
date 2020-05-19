package no.kommune.oslo.model

import no.kommune.oslo.methodology.DiscreetThreatPresenceCalculation
import org.apache.logging.log4j.LogManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertFailsWith

internal class FileThreatLibraryRepositoryTest {
    private val logger = LogManager.getLogger(javaClass)
    private val env: MutableMap<String, String> = System.getenv()
    private val testPath = "${env["PWD"]}"
    private val testFileName = "threatLibraryTestFile.json"

    @Test
    fun `Expect exeption thrown with illegal parameter`() {
        assertFailsWith<IllegalArgumentException> {
            val riskScenarioRepo = FileThreatLibraryRepository(path = "", fileName = "somefile")
        }
        assertFailsWith<IllegalArgumentException> {
            val riskScenarioRepo = FileThreatLibraryRepository(path = ".", fileName = "")
        }
    }

    @Test
    fun `Write, read ThreatLibrary and finally delete file`() {
        val threatLibrary = createThreatAgentList()
        val testfile = "$testPath/$testFileName"
        val threatLibraryRepo = FileThreatLibraryRepository(path = testPath, fileName = testFileName)
        threatLibraryRepo.writeThreatAgents(threatLibrary)
        assertThat(File(testfile).exists()).isTrue()
        val readThreatLibrary = threatLibraryRepo.readThreatAgents()
        assertThat(threatLibrary.size).isEqualTo(readThreatLibrary.size)

        assertThat(File(testfile).exists()).isTrue()

        if (!File(testfile).exists()) return
        logger.debug("Removing $testfile")
        File(testfile).delete()
    }

    private fun createThreatAgentList(): List<ThreatAgent> {
        val discreteTPCalc = DiscreetThreatPresenceCalculation(isPresent = true, hasCapacity = false, hasIntention = true, hasHistory = true, isTarget = false)

        return listOf<ThreatAgent>(
                ThreatAgent(
                        ThreatAgentType.HUMAN,
                        "Test agent 1",
                        "Test agent 1 description",
                        "Motivation 1",
                        "Affiliation 1",
                        listOf(Threat(ThreatTypes.ACCIDENTAL, discreteTPCalc, "Test threat 1.1"), Threat(ThreatTypes.ACCIDENTAL, discreteTPCalc, "Test threat 1.2")),
                        "Source 1"
                ),
                ThreatAgent(
                        ThreatAgentType.HUMAN,
                        "Test agent 2",
                        "Test agent 2 description",
                        "Motivation 2",
                        "Affiliation 2",
                        listOf(Threat(ThreatTypes.ACCIDENTAL, discreteTPCalc, "Test threat 2.1"), Threat(ThreatTypes.ACCIDENTAL, discreteTPCalc, "Test threat 2.2")),
                        "Source 2"
                ),
                ThreatAgent(
                        ThreatAgentType.HUMAN,
                        "Test agent 3",
                        "Test agent 3 description",
                        "Motivation 3",
                        "Affiliation 3",
                        listOf(Threat(ThreatTypes.ACCIDENTAL, discreteTPCalc, "Test threat 3.1"), Threat(ThreatTypes.ACCIDENTAL, discreteTPCalc, "Test threat 3.2")),
                        "Source 3"
                ),
                ThreatAgent(
                        ThreatAgentType.ENVIRONMENTAL,
                        "Test agent 4",
                        "Test agent 4 description",
                        "Motivation 4",
                        "Affiliation 4",
                        listOf(Threat(ThreatTypes.ACCIDENTAL, discreteTPCalc, "Test threat 4.1"), Threat(ThreatTypes.ACCIDENTAL, discreteTPCalc, "Test threat 4.2")),
                        "Source 4"
                ),
                ThreatAgent(
                        ThreatAgentType.HUMAN,
                        "Test agent 5",
                        "Test agent 5 description",
                        "Motivation 5",
                        "Affiliation 5",
                        listOf(Threat(ThreatTypes.ACCIDENTAL, discreteTPCalc, "Test threat 5.1"), Threat(ThreatTypes.ACCIDENTAL, discreteTPCalc, "Test threat 5.2")),
                        "Source 5"
                )
        )
    }


    @Test
    fun readThreatAgents() {
        val testFilePath = "$testPath/src/main/resources"
        val testFile = "threatagents.json"
        logger.debug("testFilePath: $testFilePath")
        val threatLibraryRepo: FileThreatLibraryRepository = FileThreatLibraryRepository(testFilePath, testFile)
        val threatAgentList: List<ThreatAgent> = threatLibraryRepo.readThreatAgents()
        logger.debug(threatAgentList)
    }

    @Test
    fun writeThreatAgents() {
    }
}