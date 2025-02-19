package com.danielrodriguez.truequesprestamosgeek.utils

class Validator {
    private val emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$".toRegex()
    private val passwordRegex = "^(?=[A-Z])(?=.*\\d)(?=.*[!@#\$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#\$%^&*(),.?\":{}|<>]{8,}$".toRegex()

    fun validarEmail(email: String): Boolean {
        return email.matches(emailRegex) && email.isNotBlank()
    }

    fun validarPassword(password: String): Boolean {
        return password.matches(passwordRegex) && password.isNotBlank()
    }
    fun validarNombreUsuario(nombre: String): Boolean {
        return nombre.isNotBlank() && nombre.isNotBlank()
    }
}