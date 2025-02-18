package com.danielrodriguez.truequesprestamosgeek.database

import org.jetbrains.exposed.dao.id.IntIdTable

object Libros : IntIdTable() {
    val titulo = varchar("titulo", 255)
    val descripcion = varchar("descripcion", 255)
    val propietarioId = integer("propietario_id").references(Usuarios.id) // Relación con Usuarios
    val autor = varchar("autor", 255)
}