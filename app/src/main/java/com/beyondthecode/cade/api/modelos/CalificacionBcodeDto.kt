package com.beyondthecode.cade.api.modelos

data class CalificacionBcodeDto(
    val calificacion: Int,
    val descripcionOpcion: String,
    val idMatCarrera: String,
    val nivelDesempenio: String,
    val nombreMateria: String,
    val numeroGrupo: String,
    val oportunidadOpcion: String,
    val semestreLlevado: String,
    val totalCreditos: String
)