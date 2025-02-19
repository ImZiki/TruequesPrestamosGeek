package com.danielrodriguez.truequesprestamosgeek.model

import org.jetbrains.exposed.dao.id.IntIdTable


object Libros : IntIdTable() {
    val titulo = varchar("titulo", 255)
    val descripcion = varchar("descripcion", 255)
    val propietario = integer("propietario").references(Usuarios.id) // Relación con Usuarios
    val autor = varchar("autor", 255)
}


data class Libro(
    override val id: Int,
    override val titulo: String,
    override val descripcion: String,
    override val propietario: Usuario,
    val autor: String
) : Producto(id, titulo, descripcion, propietario)
