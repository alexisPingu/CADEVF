package com.beyondthecode.cade.api.modelos.cargaRespDTO

data class IdAdministrativoFk(
    val ape1Administrativo: String,
    val ape2Administrativo: String,
    val carreraBcodes: List<Any>,
    val contraseniaAdministrativo: String,
    val correoAdministrativo: String,
    val direccionAdministrativo: String,
    val id: Int,
    val idRolFk: IdRolFk,
    val nombreAdministrativo: String,
    val statusAdministrativo: String,
    val telefonoAdministrativo: String
)