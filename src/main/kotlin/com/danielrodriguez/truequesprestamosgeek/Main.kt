package com.danielrodriguez.truequesprestamosgeek

import com.danielrodriguez.truequesprestamosgeek.cli.CliApp
import com.danielrodriguez.truequesprestamosgeek.db.DatabaseFactory

import org.h2.tools.Server


// Función para mostrar el menú


fun main(args: Array<String>) {
    val database = DatabaseFactory()
    val terminal = CliApp()


    //TODO Acordarme de eliminar startH2WebServer() al terminar el proyecto
    startH2WebServer()
    try {
        database.init()
        terminal.init()

    }catch (e: Exception) {
        println(e.message)
    }
}
fun startH2WebServer() {
    // Crear e iniciar el servidor web de H2 en el puerto 8082
    val webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082")
    webServer.start()
    println("Consola web de H2 disponible en http://localhost:8082")
}


