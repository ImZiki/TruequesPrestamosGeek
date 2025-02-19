package com.danielrodriguez.truequesprestamosgeek.db

import com.danielrodriguez.truequesprestamosgeek.model.entities.Libros
import com.danielrodriguez.truequesprestamosgeek.model.entities.Productos
import com.danielrodriguez.truequesprestamosgeek.model.entities.Usuarios
import com.danielrodriguez.truequesprestamosgeek.model.entities.Videojuegos
import com.danielrodriguez.truequesprestamosgeek.model.enums.Plataforma
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.mindrot.jbcrypt.BCrypt


class DatabaseFactory {
    //TODO Quitar mensajes a consola de las pruebas.
    companion object {
        private var isConnected = false
    }
    fun init(){
        connect()
        crearTablas()
        llenarTablas()
    }

    private fun llenarTablas() {
        transaction {
            if (Usuarios.select { Usuarios.email eq "admin@admin.com" }.empty()) {
                val usuario1 = Usuarios
                    .insertAndGetId {
                        it[nombre] = "Admin"
                        it[email] = "admin@admin.com"
                        it[password] = BCrypt.hashpw("admin", BCrypt.gensalt())
                    }
                println("👤 Usuario Juan insertado.")
            }
        }
    }


    private fun crearTablas() {
        transaction {
            SchemaUtils.drop(Usuarios, Videojuegos, Libros, Productos) // Dropea las tablas
            SchemaUtils.create(Usuarios, Videojuegos, Libros, Productos) // Crea las tablas
        }
        println("💥 Tablas eliminadas y recreadas con éxito.")
    }

    private fun connect() {
        if (!isConnected) {
            try {
                Database.connect(
                    "jdbc:h2:file:./data/mi_basedatos",  // Ruta a tu base de datos
                    driver = "org.h2.Driver",
                    user = "sa",
                    password = ""
                )
                isConnected = true
                println("📌 Base de datos conectada correctamente.")
            } catch (e: Exception) {
                println("🚨 Error al conectar con la base de datos: ${e.message}")
            }
        } else {
            println("⚠️ Ya estás conectado a la base de datos.")
        }
    }
}
