package com.beyondthecode.cade.api.modelos

data class HorarioDTOItem(
    val claveMateriaFk: ClaveMateriaFk,
    val idGrupoFk: IdGrupoFk,
    val periodoSemestre: String
)