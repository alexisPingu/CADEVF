package com.beyondthecode.cade.api.modelos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class InicioDto(
    @Expose
    @SerializedName("inicio")
    val inicio: String? = null
)