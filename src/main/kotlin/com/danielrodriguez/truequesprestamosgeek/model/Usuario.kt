package com.danielrodriguez.truequesprestamosgeek.model

data class Usuario(
    val id : Int,
    val nombre: String,
    var email: String,
    var password : String
)
