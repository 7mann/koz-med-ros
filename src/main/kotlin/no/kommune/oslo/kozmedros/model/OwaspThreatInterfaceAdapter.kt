package no.kommune.oslo.kozmedros.model

import com.google.gson.*
import java.lang.reflect.Type

class OwaspThreatInterfaceAdapter : JsonDeserializer<Any>, JsonSerializer<Any> {

    companion object {
        const val CLASSNAME = "CLASSNAME"
        const val DATA = "DATA"
    }


    override fun serialize(jsonElement: Any, type: Type, jsonSerializationContext: JsonSerializationContext): JsonElement {
        val jsonObject = JsonObject()
        jsonObject.addProperty(CLASSNAME, jsonElement.javaClass.name)
        jsonObject.add(DATA, jsonSerializationContext.serialize(jsonElement))
        return jsonObject
    }

    private fun getObjectClass(className: String): Class<*> {
        try {
            return Class.forName(className)
        } catch (e: ClassNotFoundException) {
            throw JsonParseException(e.message)
        }

    }

    override fun deserialize(p0: JsonElement?, p1: Type?, p2: JsonDeserializationContext?): Any {
        TODO("Not yet implemented")
    }
}