package com.danielrodriguez.truequesprestamosgeek.model

enum class Plataforma(val nombre :String) {
    PC("PC"),
    PS5("PS5"),
    XBOX("Xbox"),
    SWITCH("Switch");
    
    companion object {
        fun fromString(value: String): Plataforma? {
            return entries.find { it.nombre.equals(value, ignoreCase = true) }
        }
    }

}