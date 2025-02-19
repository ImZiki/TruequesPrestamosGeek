package com.danielrodriguez.truequesprestamosgeek.controller

import com.danielrodriguez.truequesprestamosgeek.model.entities.Usuario
import com.danielrodriguez.truequesprestamosgeek.service.UsuarioService
import com.danielrodriguez.truequesprestamosgeek.utils.errors.FormatoInvalidoException

class UsuarioController() {
    private val service = UsuarioService()

    fun registrarUsuario(nombre: String, email: String, password: String): Usuario {
        if(nombre.isBlank() || email.isBlank() || password.isBlank())
            throw FormatoInvalidoException("Los campos no pueden estar en blanco")
        return service.registrarUsuario(nombre, email, password)
    }

    fun login(email: String, password: String): Usuario {
        if (email.isBlank() || password.isBlank())
            throw FormatoInvalidoException("Los campos no pueden estar en blanco")
        return service.login(email, password)

    }

}