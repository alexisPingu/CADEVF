package com.beyondthecode.cade.api.modelos.cargaRespDTO

data class ClaveMateriaFk(
    val horasPracticas: String,
    val horasTeoricas: String,
    val id: String,
    val nombreMateria: String,
    val statusMateria: String,
    val totalCreditos: String
)