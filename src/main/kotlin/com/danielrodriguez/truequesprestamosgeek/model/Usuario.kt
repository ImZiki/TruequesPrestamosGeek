package com.danielrodriguez.truequesprestamosgeek.model

import org.jetbrains.exposed.dao.id.IntIdTable

object Usuarios : IntIdTable() {
    val nombre = varchar("nombre", 50)
    val email = varchar("email", 50).uniqueIndex()
    val password = varchar("password", 255)

}


data class Usuario(
    val id : Int,
    val nombre: String,
    var email: String,
    var password : String
)
