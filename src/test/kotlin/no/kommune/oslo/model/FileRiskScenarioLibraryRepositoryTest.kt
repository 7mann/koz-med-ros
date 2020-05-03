package no.kommune.oslo.model

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.apache.logging.log4j.LogManager
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertFailsWith

internal class FileRiskScenarioLibraryRepositoryTest {
    private val logger = LogManager.getLogger(javaClass)

    @Test
    fun `Expect exeption thrown with illegal parameter`() {
        assertFailsWith<IllegalArgumentException> {
            val riskScenarioRepo = FileRiskScenarioLibraryRepository(fileName = "")
        }

    }

    @Test
    fun readRiskScenarios() {
    }

    @Test
    fun writeRiskScenarios() {
        val env: MutableMap<String, String> = System.getenv()
        logger.debug("KOZ_FILES: ${env["KOZ_FILES"]}")

//        val gson = Gson()
        val gson = GsonBuilder().setPrettyPrinting().create()
//        val riskScenario = RiskScenario(RiskType.ASSET, "Test RiskScenario")
        val riskScenarios = listOf(
                RiskScenario(RiskType.ASSET, "Test RiskScenario 1 "),
                RiskScenario(RiskType.LEGAL, "Test RiskScenario 2 "),
                RiskScenario(RiskType.PERSONAL_DATA, "Test RiskScenario 3 "),
                RiskScenario(RiskType.ASSET, "Test RiskScenario 4 "),
                RiskScenario(RiskType.ASSET, "Test RiskScenario 5 ")
        )


        var jsonString: String = gson.toJson(riskScenarios)
        logger.debug(jsonString)

        val fileName = "${env["KOZ_FILES"]}/test.json"
        val file = File(fileName)
        file.writeText(jsonString)


        val arrayRiskScenarioType = object : TypeToken<List<RiskScenario>>() {}.type
        var riskScenarioList: List<RiskScenario> = gson.fromJson(jsonString, arrayRiskScenarioType)
        logger.debug(riskScenarioList)


//        gson.toJson(riskScenario, File("${env["KOZ_FILES"]}/test.json").writer())

    }
}