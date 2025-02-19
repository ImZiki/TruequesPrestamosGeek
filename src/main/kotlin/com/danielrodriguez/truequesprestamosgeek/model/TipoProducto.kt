package com.danielrodriguez.truequesprestamosgeek.model

enum class TipoProducto(val nombre:String) {
    VIDEOJUEGO("Videojuego"),
    LIBRO("Libro");

    companion object {
        private val map = entries.associateBy(TipoProducto::nombre)
    }
}