#!/usr/bin/env kscript

val estadosAbranger = mutableSetOf("mt", "wa", "or", "id", "nv", "ut", "ca", "az")

val estacoes = mutableMapOf<String, Set<String>>()

estacoes["kum"] = mutableSetOf("id", "nv", "ut")
estacoes["kdois"] = mutableSetOf("wa", "id", "mt")
estacoes["ktres"] = mutableSetOf("or", "nv", "ca")
estacoes["kquatro"] = mutableSetOf("nv", "ut")
estacoes["kcinco"] = mutableSetOf("ca", "az")

val estacoesFinal = mutableSetOf<String>()

while (estadosAbranger.isNotEmpty()) {
    var melhorEstacao = ""
    var estadosCobertos = mutableSetOf<String>()

    for ((key, value) in estacoes.entries) {
        var cobertos = estadosAbranger.intersect(value)
        if (cobertos.size > estadosCobertos.size) {
            melhorEstacao = key
            estadosCobertos = cobertos as MutableSet<String>
        }
    }

    estadosAbranger.removeAll(estadosCobertos)
    estacoesFinal.add(melhorEstacao)
}

println(estacoesFinal)