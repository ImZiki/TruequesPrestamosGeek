package com.danielrodriguez.truequesprestamosgeek.model

import org.jetbrains.exposed.dao.id.IntIdTable


object Videojuegos : IntIdTable() {
    val titulo = varchar("titulo", 255)
    val descripcion = varchar("descripcion", 255)
    val propietario = integer("propietario").references(Usuarios.id) // Relación con Usuarios
    val plataforma = varchar("plataforma", 50)
}

data class Videojuego(
    override val id: Int,
    override val titulo: String,
    override val descripcion: String,
    override val propietario: Usuario,
    val plataforma: Plataforma
): Producto(id, titulo, descripcion, propietario)
