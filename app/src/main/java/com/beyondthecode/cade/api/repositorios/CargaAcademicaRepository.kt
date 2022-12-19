package com.beyondthecode.cade.api.repositorios

import com.beyondthecode.cade.api.modelos.CargaA
import com.beyondthecode.cade.api.modelos.cargaRespDTO.CargaDto
import retrofit2.Call
import retrofit2.http.*

interface CargaAcademicaRepository {
    @Headers(
        "Content-Type: application/json",
        "Transfer-Encoding: chunked"
    )
    @POST("/carga/id/")
    fun addCarga(@Body carga: CargaA): Call<CargaDto>

    @GET("/carga/exist/id/{id}/")
    fun getExistCarga(@Path("id") num: String): Call<Boolean>
}