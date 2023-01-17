package com.beyondthecode.cade.api.repositorios

import com.beyondthecode.cade.api.modelos.InicioDto
import retrofit2.Call
import retrofit2.http.GET

interface InicioRepository {
    @GET("/inicio")
    fun getInicio(): Call<InicioDto>
}
