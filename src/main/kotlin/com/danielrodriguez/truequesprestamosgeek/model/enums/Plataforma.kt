package com.danielrodriguez.truequesprestamosgeek.model.enums

enum class Plataforma(val nombre :String) {
    PC("PC"),
    PS5("PS5"),
    XBOX("Xbox"),
    SWITCH("Switch");
    
    companion object {
        private val map = entries.associateBy(Plataforma::name)
    }

}