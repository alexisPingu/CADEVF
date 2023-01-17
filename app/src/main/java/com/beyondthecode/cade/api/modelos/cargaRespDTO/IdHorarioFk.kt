package com.beyondthecode.cade.api.modelos.cargaRespDTO

data class IdHorarioFk(
    val claveCarreraFk: ClaveCarreraFk,
    val claveMateriaFk: ClaveMateriaFk,
    val id: Int,
    val idAdministrativoFk: IdAdministrativoFk,
    val idGrupoFk: IdGrupoFk,
    val periodoSemestre: String
)