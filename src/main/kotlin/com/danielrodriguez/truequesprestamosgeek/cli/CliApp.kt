package com.danielrodriguez.truequesprestamosgeek.cli

import com.danielrodriguez.truequesprestamosgeek.controller.CliController

class CliApp{
    fun start(){
        //TODO cambiar parametros de entrada al metodo.
        var login = false
        var error = null.orEmpty()
        while (login){
            println("Introduce usuario: ")
            val username = readlnOrNull() ?:continue
            println("Introduce contraseña: ")
            val password = readlnOrNull() ?:continue
            login = CliController.login(username, password)

        }

    }
    fun menu(){
        println("=== Trueque & Préstamos Geek ===")
        println("1. Registrar nuevo usuario")
        println("2. Agregar producto")
        println("3. Listar productos")
        println("4. Crear solicitud")
        println("5. Listar solicitudes")
        println("6. Actualizar estado de solicitud")
        println("7. Ficheros Carga productos (txt, json)")
        println("8. Ficheros Descarga productos (txt, json)")
        println("0. Salir")
        print("Seleccione una opción: ")

        val opcion = readlnOrNull()?.toIntOrNull()

        when(opcion){

        }
    }
}