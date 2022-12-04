package com.beyondthecode.cade.api.modelos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class AlumnoDto (
    @Expose
    @SerializedName("id")
    var id: String,
    @Expose
    @SerializedName("nombreAlumno")
    var nombreAlumno: String,
    @Expose
    @SerializedName("ape1Alumno")
    var ape1Alumno: String,
    @Expose
    @SerializedName("ape2Alumno")
    var ape2Alumno: String,
    @Expose
    @SerializedName("telefonoAlumno")
    var telefonoAlumno: String,
    @Expose
    @SerializedName("correoAlumno")
    var correoAlumno: String,
    @Expose
    @SerializedName("direccionAlumno")
    var direccionAlumno: String,
    @Expose
    @SerializedName("fechaNacimientoAlumno")
    var fechaNacimientoAlumno: String,
    @Expose
    @SerializedName("contraseniaAlumno")
    var contraseniaAlumno: String,
    @Expose
    @SerializedName("generoAlumno")
    var generoAlumno: Char,
    @Expose
    @SerializedName("claveCarreraFk")
    var claveCarreraFk: String
): java.io.Serializable
