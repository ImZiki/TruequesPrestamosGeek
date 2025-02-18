package com.danielrodriguez.truequesprestamosgeek.database

import org.jetbrains.exposed.sql.Database


class DatabaseFactory {

    companion object {
        private var isConnected = false
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
