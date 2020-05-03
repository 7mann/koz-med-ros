package no.kommune.oslo.model

import com.google.gson.Gson
import com.google.gson.GsonBuilder

class FileRiskScenarioLibraryRepository(val fileName: String) : RiskScenarioLibraryRepository {
    init {
        if (fileName.isBlank()) {
            throw IllegalArgumentException("File name must be present!")
        }
    }

    override fun readRiskScenarios(): List<RiskScenario> {
        TODO("Not yet implemented")
    }

    override fun writeRiskScenarios(riskScenarios: List<RiskScenario>) {
        val gson: Gson = GsonBuilder().setPrettyPrinting().create()

        TODO("Not yet implemented")
    }
}