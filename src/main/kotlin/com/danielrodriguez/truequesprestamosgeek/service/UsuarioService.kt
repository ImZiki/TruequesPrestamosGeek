package com.danielrodriguez.truequesprestamosgeek.service

import com.danielrodriguez.truequesprestamosgeek.dao.UsuarioDAO
import com.danielrodriguez.truequesprestamosgeek.model.entities.Usuario
import com.danielrodriguez.truequesprestamosgeek.utils.Validator
import com.danielrodriguez.truequesprestamosgeek.utils.errors.FormatoInvalidoException
import com.danielrodriguez.truequesprestamosgeek.utils.errors.LoginException
import com.danielrodriguez.truequesprestamosgeek.utils.errors.RegistroException
import org.mindrot.jbcrypt.BCrypt

class UsuarioService {
    private val usuarioDAO = UsuarioDAO()
    private val validator = Validator()


    fun login(email: String, password: String): Usuario {
        // Comprobación del correo
        if (!validator.validarEmail(email)) throw FormatoInvalidoException("Email invalido")
        try {
            return usuarioDAO.login(email, password)
        }catch(e: Exception) {
            throw LoginException("Credenciales incorrectas")
        }

    }


    fun registrarUsuario(nombre: String, email: String, password: String): Usuario {
        if(!validator.validarEmail(email))
            throw FormatoInvalidoException("Email invalido. Debe ser una direccion de correo electrónico valida")
        if(!validator.validarPassword(password))
            throw FormatoInvalidoException("Contraseña inválida. La contraseña debe tener al menos 8 caracteres, empezar con una mayúscula, " +
                "contener al menos un número y un carácter especial (como !, @, #, $, etc.).")
        val hashedpw = BCrypt.hashpw(password, BCrypt.gensalt())

        try{
            return usuarioDAO.registrarUsuario(nombre, email, hashedpw)
        }catch (e: Exception){
            throw RegistroException("Error en registro, intentelo de nuevo mas tarde")
        }
    }


}