package no.kommune.oslo.model

import no.kommune.oslo.model.SeverityLevels.*

data class RiskApetite(val riskMatrix: Array<Array<SeverityLevels>>) {
    private val lowerBoundary = 1
    private val higerBoundary =5

    init {
        if (riskMatrix == null) throw IllegalArgumentException("RiskMatrix can not be null!")
        if (riskMatrix.size != 5) throw IllegalArgumentException("RiskMatrix size has to be 5!")
    }


    fun returnRisk(consequence: Int, probability: Int): SeverityLevels {
        return INSIGNIFICANT
    }

    override fun toString(): String {
        val consArray = riskMatrix
        var outString = ""
        for (j in 0..4) {
            val k = 4 - j
            for (i in 0..4) {
                val probArray = consArray[i]
                val severity = probArray[k].toString()
                outString += centerText(severity,12)
            }
            outString += "\n"
        }
        return outString
    }

    private fun centerText(text: String, textBlockSize: Int): String {
        val textLen = text.length
        val padding = textBlockSize - textLen
        val padLeft = padding/2
        var padRight = padLeft
        if (padRight*2 != padding) {
            padRight += 1
        }
        var returnText = text.padStart(padLeft + textLen)
        returnText = returnText.padEnd(returnText.length + padRight)
        return (returnText)
    }

    fun getSeverityLevel(consequenceIndex: Int, probabilityIndex: Int): SeverityLevels {
        if (consequenceIndex < lowerBoundary || consequenceIndex > higerBoundary) {
            throw ArrayIndexOutOfBoundsException("Consequence index must be between ${lowerBoundary} and ${higerBoundary}!")
        }
        if (probabilityIndex < lowerBoundary || consequenceIndex > higerBoundary) {
            throw ArrayIndexOutOfBoundsException("Probability index must be between ${lowerBoundary} and ${higerBoundary}!")
        }
        val consequenceArrayIndex = consequenceIndex - 1 //Note! Have to convert to Array indexes starting at 0
        val probabilityArrayIndex = probabilityIndex - 1 //Note! Have to convert to Array indexes starting at 0
        val probabilityArray = riskMatrix[consequenceArrayIndex]
        return probabilityArray[probabilityArrayIndex]
    }

}