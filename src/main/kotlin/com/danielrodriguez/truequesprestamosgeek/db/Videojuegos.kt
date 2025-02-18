package com.danielrodriguez.truequesprestamosgeek.database

import org.jetbrains.exposed.dao.id.IntIdTable

object Videojuegos : IntIdTable() {
    val titulo = varchar("titulo", 255)
    val descripcion = varchar("descripcion", 255)
    val propietarioId = integer("propietario_id").references(Usuarios.id) // Relación con Usuarios
    val plataforma = varchar("plataforma", 50)
}