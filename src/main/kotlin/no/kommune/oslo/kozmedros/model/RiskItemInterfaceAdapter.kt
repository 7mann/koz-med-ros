package no.kommune.oslo.kozmedros.model

import com.google.gson.*
import java.lang.reflect.Type

class RiskItemInterfaceAdapter : JsonDeserializer<Any>, JsonSerializer<Any> {

    companion object {
        const val CLASSNAME = "CLASSNAME"
        const val DATA = "DATA"
    }

    @Throws(JsonParseException::class)
    override fun deserialize(jsonElement: JsonElement, type: Type,
                             jsonDeserializationContext: JsonDeserializationContext): Any {

        val jsonObject = jsonElement.asJsonObject

//        val tp = jsonElement.asLong("threatPresence")

        val prim = jsonObject.get(CLASSNAME) as JsonPrimitive?
        val cName: String
        if (prim == null) {
            cName = "no_class"
        } else {
            cName = prim.asString
        }
//        val cName: String? = prim!!.asString
//        val className: String? = prim!!.asString
        val className: String = cName
        val objectClass = getObjectClass(className)
        return jsonDeserializationContext.deserialize(jsonObject.get(DATA), objectClass)
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
}