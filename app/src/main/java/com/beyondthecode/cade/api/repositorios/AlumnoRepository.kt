package com.beyondthecode.cade.api.repositorios

import com.beyondthecode.cade.api.modelos.AlumnoDto
import retrofit2.Call
import retrofit2.http.*

interface AlumnoRepository {
    @Headers("Content-Type: application/json")
    @POST("/alumno/registro")
    fun addUser(@Body alumno: AlumnoDto): Call<AlumnoDto>

    @GET("/alumno/auth")
    fun getAlumnAuth(@Query("id") id: String, @Query("contra") contra: String): Call<AlumnoDto>
}