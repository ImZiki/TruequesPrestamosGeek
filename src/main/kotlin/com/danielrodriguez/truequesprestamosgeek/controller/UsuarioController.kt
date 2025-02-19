package com.danielrodriguez.truequesprestamosgeek.controller

import com.danielrodriguez.truequesprestamosgeek.model.Usuario
import com.danielrodriguez.truequesprestamosgeek.model.Usuarios
import com.danielrodriguez.truequesprestamosgeek.utils.errors.LoginException
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.mindrot.jbcrypt.BCrypt

class UsuarioController() {

    fun registrarUsuario(nombre: String, email: String, password: String): Usuario {
        //TODO llamada a UsuarioService.registrarUsuario()
        // Lógica para registrar usuario
        return transaction{
            val usuarioId = Usuarios.insertAndGetId {
                it[Usuarios.nombre] = nombre
                it[Usuarios.email] = email
                it[Usuarios.password] = BCrypt.hashpw(password, BCrypt.gensalt())
            }
            Usuario(
                id = usuarioId.value,
                nombre = nombre,
                email = email,
                password = BCrypt.hashpw(password, BCrypt.gensalt()),

            )
        }
    }

    fun login(email: String, password: String): Usuario {
        //TODO llamada a UsuarioService.login
        return transaction {
            // Buscar en la base de datos el usuario con el email proporcionado
            val usuario = Usuarios
                .select { Usuarios.email eq email }
                .singleOrNull()  // Obtiene un solo resultado o null si no existe

            // Si el usuario existe, verificamos si la contraseña es correcta
            usuario?.let {
                val storedPassword = it[Usuarios.password]  // Contraseña guardada en la base de datos

                // Comparamos la contraseña proporcionada con la guardada usando BCrypt
                if (BCrypt.checkpw(password, storedPassword)) {
                    // Si la contraseña es correcta, devolvemos el objeto Usuario
                    return@transaction Usuario(
                        id = it[Usuarios.id].value,
                        nombre = it[Usuarios.nombre],
                        email = it[Usuarios.email],
                        password = storedPassword
                    )
                } else {
                    // Si las contraseñas no coinciden, retornamos null
                    throw LoginException("Credenciales incorrectas")
                }
            }
            // Si no se encuentra el usuario o la contraseña no es correcta, retornamos null
            throw LoginException("Credenciales incorrectas")
        }
    }
}