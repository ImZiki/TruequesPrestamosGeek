package com.danielrodriguez.truequesprestamosgeek.model.enums

enum class TipoProducto(val nombre:String) {
    VIDEOJUEGO("Videojuego"),
    LIBRO("Libro");

    companion object {
        private val map = entries.associateBy(TipoProducto::nombre)
    }
}