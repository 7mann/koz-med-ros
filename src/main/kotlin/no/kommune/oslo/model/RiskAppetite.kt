package no.kommune.oslo.model

import no.kommune.oslo.model.enums.SeverityLevel

data class RiskAppetite(val riskMatrix: Array<Array<SeverityLevel>>) {
    private val lowerBoundary = 1
    private val higherBoundary = 5

    init {
        if (riskMatrix.size != higherBoundary) throw IllegalArgumentException("RiskMatrix size has to be ${higherBoundary}!")
    }

    fun getSeverityLevel(consequenceIndex: Int, probabilityIndex: Int): SeverityLevel {
        if (consequenceIndex < lowerBoundary || consequenceIndex > higherBoundary) {
            throw ArrayIndexOutOfBoundsException("Consequence index must be between ${lowerBoundary} and ${higherBoundary}!")
        }
        if (probabilityIndex < lowerBoundary || consequenceIndex > higherBoundary) {
            throw ArrayIndexOutOfBoundsException("Probability index must be between ${lowerBoundary} and ${higherBoundary}!")
        }
        val consequenceArrayIndex = consequenceIndex - 1 //Note! Have to convert to Array indexes starting at 0
        val probabilityArrayIndex = probabilityIndex - 1 //Note! Have to convert to Array indexes starting at 0
        val probabilityArray = riskMatrix[consequenceArrayIndex]
        return probabilityArray[probabilityArrayIndex]
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
}