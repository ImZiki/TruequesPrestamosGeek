package com.danielrodriguez.truequesprestamosgeek.model

data class Videojuego(
    override val id: Int,
    override val titulo: String,
    override val descripcion: String,
    override val propietario: Usuario,
    val plataforma: Plataforma
): Producto(id, titulo, descripcion, propietario)
