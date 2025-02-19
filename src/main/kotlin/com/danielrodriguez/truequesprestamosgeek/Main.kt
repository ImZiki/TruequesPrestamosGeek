package com.danielrodriguez.truequesprestamosgeek

import com.danielrodriguez.truequesprestamosgeek.db.DatabaseFactory
import org.h2.tools.Server


fun main(args: Array<String>) {
    val database = DatabaseFactory()


    try{
        database.init()
    }catch (e: Exception){
        println(e)
    }

    fun startH2WebServer() {
        // Crear e iniciar el servidor web de H2 en el puerto 8082
        val webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082")
        webServer.start()
        println("Consola web de H2 disponible en http://localhost:8082")
        readlnOrNull()
    }

    startH2WebServer()
}