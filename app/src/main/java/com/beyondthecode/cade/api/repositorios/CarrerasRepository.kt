package com.beyondthecode.cade.api.repositorios

import com.beyondthecode.cade.api.modelos.CarrerasDto
import retrofit2.Call
import retrofit2.http.GET

interface CarrerasRepository {
    @GET("/carreras")
    fun getCarreras(): Call<List<CarrerasDto>>
}