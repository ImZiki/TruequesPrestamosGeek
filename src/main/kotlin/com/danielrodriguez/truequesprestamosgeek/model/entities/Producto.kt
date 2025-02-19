package com.danielrodriguez.truequesprestamosgeek.model.entities

import com.danielrodriguez.truequesprestamosgeek.model.entities.Usuario
import org.jetbrains.exposed.dao.id.IntIdTable

object Productos : IntIdTable(){
    val tipo = varchar("tipo", 255)
    val productoId = integer("producto_id")
}


abstract class Producto(
    open val id: Int,
    open val titulo: String,
    open val descripcion: String,
    open val propietario: Usuario
)