package no.kommune.oslo.kozmedros.model.repository

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.File

open class FileLibraryRepository() {

    protected inline fun <reified T : Any> readJsonFile(fileNameAndPath: String, jsonFormat: Json = Json { prettyPrint = true }): List<T> {
        if (!File(fileNameAndPath).exists()) {
            throw IllegalArgumentException("File $fileNameAndPath does not exist!")
        }
        val bufferedReader: BufferedReader = File(fileNameAndPath).bufferedReader()
        val inputString = bufferedReader.use { it.readText() }
        val libraryList: List<T> = jsonFormat.decodeFromString<List<T>>(inputString)
        return libraryList
    }

    protected inline fun <reified T> writeJsonFile(libraryList: List<T>, fileNameAndPath: String, jsonFormat: Json = Json { prettyPrint = true }) {
        if (libraryList.isNullOrEmpty()) {
            throw IllegalArgumentException("Library list can not be null or empty!")
        }
        if (fileNameAndPath.isNullOrBlank()) {
            throw IllegalArgumentException("Filename argument can not be empty or null!!")
        }

        val jsonString = jsonFormat.encodeToString(libraryList)
        // logger.debug("Writing ${libraryList.size} records to library ${fileNameAndPath}")
        val file = File(fileNameAndPath)
        file.writeText(jsonString)
    }
}