package com.danielrodriguez.truequesprestamosgeek.model

data class Libro(
    override val id: Int,
    override val titulo: String,
    override val descripcion: String,
    override val propietario: Usuario,
    val autor: String
) : Producto(id, titulo, descripcion, propietario)
