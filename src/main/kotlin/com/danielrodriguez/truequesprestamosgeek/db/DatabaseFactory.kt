package com.danielrodriguez.truequesprestamosgeek.db

import com.danielrodriguez.truequesprestamosgeek.model.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.mindrot.jbcrypt.BCrypt


class DatabaseFactory {

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
            // Insertando usuarios mockup, comprobando si ya existen
            if (Usuarios.select { Usuarios.email eq "juan@email.com" }.empty()) {
                val usuario1 = Usuarios
                    .insertAndGetId {
                        it[nombre] = "Juan"
                        it[email] = "juan@email.com"
                        it[password] = BCrypt.hashpw("123456", BCrypt.gensalt())
                    }
                println("👤 Usuario Juan insertado.")
            }

            if (Usuarios.select { Usuarios.email eq "maria@email.com" }.empty()) {
                val usuario2 = Usuarios
                    .insertAndGetId {
                        it[nombre] = "Maria"
                        it[email] = "maria@email.com"
                        it[password] = BCrypt.hashpw("abcdef", BCrypt.gensalt())
                    }
                println("👤 Usuario Maria insertado.")
            }

            // Insertando videojuegos mockup, comprobando si ya existen
            if (Videojuegos.select { Videojuegos.titulo eq "Super Mario" }.empty()) {
                Videojuegos
                    .insert {
                        it[titulo] = "Super Mario"
                        it[descripcion] = "Un juego de plataformas clásico."
                        it[plataforma] = Plataforma.SWITCH.nombre
                        it[propietario] = 1 // Usamos un id de usuario que ya sabemos existe
                    }
            }

            if (Videojuegos.select { Videojuegos.titulo eq "The Witcher 3" }.empty()) {
                Videojuegos
                    .insert {
                        it[titulo] = "The Witcher 3"
                        it[descripcion] = "Un juego de rol de mundo abierto."
                        it[plataforma] = Plataforma.PC.nombre
                        it[propietario] = 2 // Usamos un id de usuario que ya sabemos existe
                    }
            }

            // Insertando libros mockup, comprobando si ya existen
            if (Libros.select { Libros.titulo eq "Harry Potter y la Piedra Filosofal" }.empty()) {
                Libros
                    .insert {
                        it[titulo] = "Harry Potter y la Piedra Filosofal"
                        it[descripcion] = "El primer libro de la saga de Harry Potter."
                        it[autor] = "J.K. Rowling"
                        it[propietario] = 1 // Usamos un id de usuario que ya sabemos existe
                    }
            }

            if (Libros.select { Libros.titulo eq "1984" }.empty()) {
                Libros
                    .insert {
                        it[titulo] = "1984"
                        it[descripcion] = "Una novela distópica de George Orwell."
                        it[autor] = "George Orwell"
                        it[propietario] = 2 // Usamos un id de usuario que ya sabemos existe
                    }
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

    fun connect() {
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
