package com.danielrodriguez.truequesprestamosgeek.model.enums

enum class EstadoSolicitud(val nombre: String) {
    PENDIENTE("Pendiente"),
    ACEPTADA("Aceptada"),
    RECHAZADA("Rechazada"),
    FINALIZADA("Finalizada"),;

    companion object {
        private val map = entries.associateBy(EstadoSolicitud::nombre)
    }
}