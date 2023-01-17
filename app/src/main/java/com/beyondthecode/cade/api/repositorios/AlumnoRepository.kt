package com.beyondthecode.cade.api.repositorios

import com.beyondthecode.cade.api.modelos.AlumnoDto
import com.beyondthecode.cade.api.modelos.AlumnoUpdateDto
import retrofit2.Call
import retrofit2.http.*

interface AlumnoRepository {
    @Headers("Content-Type: application/json")
    @POST("/alumno/registro")
    fun addUser(@Body alumno: AlumnoDto): Call<AlumnoDto>

    @GET("/alumno/auth")
    fun getAlumnAuth(@Query("id") id: String, @Query("contra") contra: String): Call<AlumnoDto>

    @Headers("Content-Type: application/json")
    @PUT("/alumno/actualizar")
    fun updateAlumn(@Body alumno: AlumnoUpdateDto, @Query("numc") id: String): Call<AlumnoDto>
}