package com.beyondthecode.cade.api.modelos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AlumnoUpdateDto(
    @Expose
    @SerializedName("correoAlumno")
    val correoAlumno: String,
    @Expose
    @SerializedName("contraseniaAlumno")
    val contraseniaAlumno: String,
    @Expose
    @SerializedName("telefonoAlumno")
    val telefonoAlumno: String,
    @Expose
    @SerializedName("direccionAlumno")
    val direccionAlumno: String
)