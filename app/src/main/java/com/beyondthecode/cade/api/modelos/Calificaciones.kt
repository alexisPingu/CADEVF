package com.beyondthecode.cade.api.modelos

data class Calificaciones(
    val ape1Alumno: String,
    val ape2Alumno: String,
    val calificacionBcodeDtoList: List<CalificacionBcodeDto>,
    val claveCarrera: String,
    val nombreAlumno: String,
    val numeroControl: String
)