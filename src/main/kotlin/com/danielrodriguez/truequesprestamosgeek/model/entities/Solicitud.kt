package com.danielrodriguez.truequesprestamosgeek.model.entities

import com.danielrodriguez.truequesprestamosgeek.model.entities.Usuarios
import com.danielrodriguez.truequesprestamosgeek.model.entities.Productos
import org.jetbrains.exposed.dao.id.IntIdTable


object Solicitudes: IntIdTable() {
    val tipo = varchar("tipo", 255)
    val solicitante = integer("solicitante").references(Usuarios.id)
    val producto = reference("producto", Productos)
    val estado = varchar("estado", 255).default("Pendiente")
}

data class Solicitud(val id:Int)
