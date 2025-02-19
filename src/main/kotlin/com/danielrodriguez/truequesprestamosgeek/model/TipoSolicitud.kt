package com.danielrodriguez.truequesprestamosgeek.model

enum class TipoSolicitud(val nombre:String) {
    PRESTAMO("Prestamo"),
    TRUEQUE("Trueque");

    companion object {
        private val map = entries.associateBy(TipoSolicitud::nombre)
    }
}