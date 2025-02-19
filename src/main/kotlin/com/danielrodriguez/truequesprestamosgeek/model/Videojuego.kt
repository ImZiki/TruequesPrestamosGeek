package com.danielrodriguez.truequesprestamosgeek.model

import org.jetbrains.exposed.dao.id.IntIdTable


object Videojuegos : IntIdTable() {
    val titulo = varchar("titulo", 255)
    val descripcion = varchar("descripcion", 255)
    var propietario = integer("propietario").references(Usuarios.id) // Relación con Usuarios
    val plataforma = varchar("plataforma", 255)
    var estado = varchar("estado", 255).default("Disponible")
}

data class Videojuego(
    override val id: Int,
    override val titulo: String,
    override val descripcion: String,
    override var propietario: Usuario,
    val plataforma: Plataforma,
    var estado: EstadoProducto,
): Producto(id, titulo, descripcion, propietario)
