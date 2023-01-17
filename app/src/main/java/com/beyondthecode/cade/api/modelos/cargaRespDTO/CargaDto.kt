package com.beyondthecode.cade.api.modelos.cargaRespDTO

data class CargaDto(
    val id: Int,
    val idHorarioFk: IdHorarioFk,
    val idOpcionFk: IdOpcionFk,
    val numeroControlFk: NumeroControlFk,
    val semestreLlevado: String,
    val statusCargaAcademica: String
)