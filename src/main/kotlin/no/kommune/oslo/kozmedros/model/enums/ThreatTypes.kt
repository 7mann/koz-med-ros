package no.kommune.oslo.kozmedros.model.enums

import kotlinx.serialization.Serializable

@Serializable
enum class ThreatTypes {
    DELIBERATE, ACCIDENTAL, EMPTY
}