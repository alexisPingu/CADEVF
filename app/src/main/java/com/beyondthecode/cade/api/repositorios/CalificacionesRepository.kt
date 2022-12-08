package com.beyondthecode.cade.api.repositorios

import com.beyondthecode.cade.api.modelos.Calificaciones
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CalificacionesRepository {
    @GET("/kardex")
    fun getKardex(@Query("numc") numc: String): Call<Calificaciones>
}