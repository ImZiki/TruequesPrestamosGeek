package com.danielrodriguez.truequesprestamosgeek.cli

import com.danielrodriguez.truequesprestamosgeek.controller.ProductoController
import com.danielrodriguez.truequesprestamosgeek.controller.SolicitudController
import com.danielrodriguez.truequesprestamosgeek.controller.UsuarioController
import com.danielrodriguez.truequesprestamosgeek.model.entities.Usuario
import com.danielrodriguez.truequesprestamosgeek.utils.errors.FormatoInvalidoException


class CliApp{
    private val usuarioController = UsuarioController()
    private val productoController = ProductoController()
    private val solicitudController = SolicitudController()

    private fun menu(usuario: String){
        println("=== Trueque & Préstamos Geek ===")
        println("Bienvenido, $usuario")
        println("1. Registrar nuevo usuario")
        println("2. Agregar producto")
        println("3. Listar productos")
        println("4. Crear solicitud")
        println("5. Listar solicitudes")
        println("6. Actualizar estado de solicitud")
        println("7. Ficheros Carga productos (txt, json)")
        println("8. Ficheros Descarga productos (txt, json)")
        println("0. Salir")
        print("Selecciona una opción: ")
    }

    fun init() {
        var usuario: Usuario? = null
        while (usuario == null){
            println("=== Login ===")
            print("Ingresa tu email: ")
            val email = readlnOrNull() ?: ""

            print("Ingresa tu contraseña: ")
            val password = readlnOrNull() ?: ""

            // Intentar hacer login con las credenciales proporcionadas
            usuario = try {
                usuarioController.login(email, password)
            } catch (e: Exception) {
                println(e.message + "\n")
                null
            }
        }
        // Mostrar el menú después de login exitoso
        var opcion: Int
        do {
            menu(usuario.nombre)
            opcion = readlnOrNull()?.toIntOrNull() ?: -1
            when (opcion) {
                1 ->{
                    try{
                        println("=== Registro de usuario ===")
                        print("Introduce nombre de usuario: ")
                        val nombre = readlnOrNull()?: ""
                        print("Introduce email: ")
                        val nuevoEmail = readlnOrNull()?: ""
                        print("Introduce contraseña: ")
                        val nuevaPassword = readlnOrNull()?:""
                        val nuevoUsuario = usuarioController.registrarUsuario(nombre, nuevoEmail, nuevaPassword)
                        println("Usuario ${nuevoUsuario.nombre} creado")
                    }catch (e: Exception){
                        println(e.message + "\n")
                    }
                }


                2 ->{
                    try {
                        println("=== Agregar Producto ===")
                        print("Introduce titulo del producto: ")
                        val titulo = readlnOrNull()?: ""
                        print("Introduce descripción del producto: ")
                        val descripcion = readlnOrNull()?: ""
                        print("Indica tipo de producto(1.Videojuego, 2.Libro): ")
                        val tipoProducto = readlnOrNull()?.toIntOrNull()?: -1
                        if(tipoProducto != 1 && tipoProducto != 2){
                            throw FormatoInvalidoException("Selecciona el tipo correcto (1 o 2)")
                        }
                        var plataforma = ""
                        var autor= ""
                        if(tipoProducto == 1){
                            print("Introduce plataforma(PC, Switch, Xbox, PS5): ")
                            plataforma = readlnOrNull()?: ""
                        }
                        if(tipoProducto == 2){
                            print("Introduce autor del libro: ")
                            autor = readlnOrNull()?: ""
                        }
                        productoController.agregarProducto(titulo, descripcion, plataforma, autor, usuario)
                        println("Producto {$titulo} creado correctamente")
                    }catch (e: Exception){
                        println(e.message + "\n")
                    }
                }
                3 ->{
                    val filtro = ""
                    productoController.listarProductos(filtro)
                }
                /*
                4 -> crearSolicitud()
                5 -> listarSolicitudes()
                6 -> actualizarEstadoSolicitud()
                7 -> ficherosCargaProductos()
                    //TODO LLAMAR A GUI DESDE AQUI
                8 -> ficherosDescargaProductos()*/
                0 -> println("Saliendo del programa...")
                else -> println("Opción no válida, por favor selecciona nuevamente.")
            }
        } while (opcion != 0)
    }
}