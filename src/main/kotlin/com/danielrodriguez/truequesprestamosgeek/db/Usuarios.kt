package com.danielrodriguez.truequesprestamosgeek.database


import org.jetbrains.exposed.dao.id.IntIdTable


object Usuarios : IntIdTable() {
    val nombre = varchar("nombre", 50)
    val email = varchar("email", 50).uniqueIndex()
    val password = varchar("password", 255)

}