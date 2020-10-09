package no.kommune.oslo.kozmedros.model

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class OwaspThreatInterfaceAdapter : JsonDeserializer<OwaspThreatPresence> {

    override fun deserialize(json: JsonElement?, type: Type?, context: JsonDeserializationContext?): OwaspThreatPresence? {
        return context?.deserialize<OwaspThreatPresence>(json, OwaspThreatPresence::class.java)
    }
}