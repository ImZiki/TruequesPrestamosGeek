package com.danielrodriguez.truequesprestamosgeek

import com.danielrodriguez.truequesprestamosgeek.cli.CliApp
import com.danielrodriguez.truequesprestamosgeek.controller.UsuarioController
import com.danielrodriguez.truequesprestamosgeek.db.DatabaseFactory
import com.danielrodriguez.truequesprestamosgeek.model.Usuario
import org.h2.tools.Server
import java.sql.SQLException


// Función para mostrar el menú


fun main(args: Array<String>) {
    val database = DatabaseFactory()
    val terminal = CliApp()
    val usuarioController = UsuarioController()


    startH2WebServer()



    try {
        database.init()
    }catch (e: SQLException) {
        println(e.message)
    }
    var usuario: Usuario? = null
    while (usuario == null){
        print("Ingresa tu email: ")
        val email = readlnOrNull() ?: ""

        print("Ingresa tu contraseña: ")
        val password = readlnOrNull() ?: ""

        // Intentar hacer login con las credenciales proporcionadas
        usuario = try {
            usuarioController.login(email, password)
        } catch (e: Exception) {
            println(e.message)
            null
        }
    }
    // Pedir email y contraseña antes de llamar a login


    // Mostrar el menú después de login exitoso
    var opcion: Int
    do {
       terminal.menu(usuario.nombre)
        opcion = readlnOrNull()?.toIntOrNull() ?: -1
        when (opcion) {
            1 ->{
                println("Introduce nombre de usuario")
                val nombre = readlnOrNull()?: ""
                println("Introduce email")
                val nuevoEmail = readlnOrNull()?: ""
                println("Introduce contraseña")
                val nuevaPassword = readlnOrNull()?:""
                val nuevoUsuario = usuarioController.registrarUsuario(nombre, nuevoEmail, nuevaPassword)
                println("Usuario ${nuevoUsuario.nombre} creado")
            }


            /*2 -> agregarProducto()
            3 -> listarProductos()
            4 -> crearSolicitud()
            5 -> listarSolicitudes()
            6 -> actualizarEstadoSolicitud()
            7 -> ficherosCargaProductos()
            8 -> ficherosDescargaProductos()*/
            0 -> println("Saliendo del programa...")
            else -> println("Opción no válida, por favor selecciona nuevamente.")
        }
    } while (opcion != 0)


}
fun startH2WebServer() {
    // Crear e iniciar el servidor web de H2 en el puerto 8082
    val webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082")
    webServer.start()
    println("Consola web de H2 disponible en http://localhost:8082")
}