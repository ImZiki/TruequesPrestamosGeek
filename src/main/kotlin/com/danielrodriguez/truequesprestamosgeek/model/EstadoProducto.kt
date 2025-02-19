package com.danielrodriguez.truequesprestamosgeek.model

enum class EstadoProducto(val nombre: String) {
    DISPONIBLE("Disponible"),
    TRUEQUE("Trueque"),
    PRESTAMO("Prestamo");

    companion object {
        private val map = entries.associateBy(EstadoProducto::nombre)
    }
}