package com.beyondthecode.cade.api.repositorios

import com.beyondthecode.cade.api.modelos.HorarioDTOItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MateriasRepository {
    @GET("/materias/carrera/{clavec}")
    fun getMaterias(@Path("clavec") clavec: String): Call<List<HorarioDTOItem>>
}