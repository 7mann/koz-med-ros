package no.kommune.oslo.model

//interface ThreatPresence<K, out V> : RiskItem{
interface ThreatPresence : RiskItem {
    //    fun getThreatPresenceParameters(): Map<K, V>
    fun getThreatPresenceParameters(): Map<String, String>
}