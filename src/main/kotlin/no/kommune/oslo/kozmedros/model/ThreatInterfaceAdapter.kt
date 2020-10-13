package no.kommune.oslo.kozmedros.model

import com.google.gson.*
import java.lang.reflect.Type

class ThreatInterfaceAdapter(val defaultClassName: String) : JsonDeserializer<Any>, JsonSerializer<Any> {
    companion object {
        const val CLASSNAME = "CLASSNAME"
    }
    override fun deserialize(json: JsonElement, type: Type, context: JsonDeserializationContext): Any {

        val classname = json.asJsonObject.get("CLASSNAME")?.asString ?: defaultClassName
        return context.deserialize<ThreatPresence>(json, getObjectClass(classname))
    }

    override fun serialize(theObject: Any, type: Type, context: JsonSerializationContext): JsonElement {
        val jsonObject = context.serialize(theObject).asJsonObject
        jsonObject.addProperty(CLASSNAME, theObject::class.java.name)
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