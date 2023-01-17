package com.beyondthecode.cade.api.modelos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CarrerasDto (
    @Expose
    @SerializedName("id")
    val id: String? = null,

    @Expose
    @SerializedName("descripcionCarrera")
    val descripcionCarrera: String? = null
)