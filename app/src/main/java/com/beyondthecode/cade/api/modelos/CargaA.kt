package com.beyondthecode.cade.api.modelos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CargaA(
    @Expose
    @SerializedName("numeroControlFkId")
    val numeroControlFkId: String,
    @Expose
    @SerializedName("idHorarioFkClaveMateriaFkId")
    val idHorarioFkClaveMateriaFkId: String,
    @Expose
    @SerializedName("idOpcionFkId")
    val idOpcionFkId: String,
    @Expose
    @SerializedName("statusCargaAcademica")
    val statusCargaAcademica: String,
    @Expose
    @SerializedName("semestreLlevado")
    val semestreLlevado: String
)