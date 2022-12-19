package com.beyondthecode.cade.api.modelos.cargaRespDTO

data class NumeroControlFk(
    val ape1Alumno: String,
    val ape2Alumno: String,
    val claveCarreraFk: ClaveCarreraFk,
    val contraseniaAlumno: String,
    val correoAlumno: String,
    val direccionAlumno: String,
    val fechaNacimientoAlumno: String,
    val generoAlumno: String,
    val id: String,
    val idRolFk: IdRolFk,
    val nombreAlumno: String,
    val statusAlumno: String,
    val telefonoAlumno: String
)