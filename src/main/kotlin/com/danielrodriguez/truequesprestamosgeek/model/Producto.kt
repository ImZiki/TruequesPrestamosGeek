package com.danielrodriguez.truequesprestamosgeek.model

abstract class Producto(
    open val id: Int,
    open val titulo: String,
    open val descripcion: String,
    open val propietario: Usuario
)