package no.kommune.oslo.model

import org.apache.logging.log4j.LogManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertFailsWith

internal class FileRiskScenarioLibraryRepositoryTest {
    private val logger = LogManager.getLogger(javaClass)
    private val env: MutableMap<String, String> = System.getenv()
    private val testPath = "${env["PWD"]}"
    private val testFileName = "riskScenarioTestFile.json"

    @Test
    fun `Expect exeption thrown with illegal parameter`() {
        assertFailsWith<IllegalArgumentException> {
            val riskScenarioRepo = FileRiskScenarioLibraryRepository(path = "", fileName = "somefile")
        }
        assertFailsWith<IllegalArgumentException> {
            val riskScenarioRepo = FileRiskScenarioLibraryRepository(path = ".", fileName = "")
        }
    }

    @Test
    fun writeAndReadRiskScenarios() {
        //TODO Implement tests
        val testfile = "$testPath/$testFileName"
        logger.debug("Writing RiskScenaerios to path: $testPath, test filename: $testFileName")
        val riskScenarios = listOf(
                RiskScenario(RiskType.ASSET, "Test RiskScenario 1 "),
                RiskScenario(RiskType.LEGAL, "Test RiskScenario 2 "),
                RiskScenario(RiskType.PERSONAL_DATA, "Test RiskScenario 3 "),
                RiskScenario(RiskType.ASSET, "Test RiskScenario 4 "),
                RiskScenario(RiskType.ASSET, "Test RiskScenario 5 ")
        )
        val riskScenarioRepo = FileRiskScenarioLibraryRepository(path = testPath, fileName = testFileName)
        riskScenarioRepo.writeRiskScenarios(riskScenarios)
        assertThat(File(testfile).exists()).isTrue()

        logger.debug("Reading RiskScenaerios from path: $testPath, test filename: $testFileName")
        val riskScenarioRepo2 = FileRiskScenarioLibraryRepository(path = testPath, fileName = testFileName)
        val riskScenarioList: List<RiskScenario> = riskScenarioRepo2.readRiskScenarios()
        assertThat(riskScenarios.size).isEqualTo(riskScenarioList.size)
        logger.debug("Read ${riskScenarioList.size} RiskScenarios from $testfile")

        assertThat(File(testfile).exists()).isTrue()

        if (!File(testfile).exists()) return
        logger.debug("Removing $testfile")
        File(testfile).delete()

    }
}