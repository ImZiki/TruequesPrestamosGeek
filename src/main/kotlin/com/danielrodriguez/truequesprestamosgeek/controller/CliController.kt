package com.danielrodriguez.truequesprestamosgeek.controller

import org.h2.engine.User

object CliController {

    private var loggedInUser : User? = null

    fun login(username:String, password: String): Boolean {
        /* TODO Recupero usuario de bd que encaje con el username y compruebo contraseña.
        * Si coinciden con los registros devuelvo true, si no, false. Por defecto retorno false
        *
        */
        if(loggedInUser == null) {
            if(username.isEmpty() || password.isEmpty()) {
                return false
            }
            if (username == "admin" && password == "1234"){
                return true
            }
        }
        return false
    }
}