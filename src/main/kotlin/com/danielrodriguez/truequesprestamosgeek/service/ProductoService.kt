package com.danielrodriguez.truequesprestamosgeek.service

import com.danielrodriguez.truequesprestamosgeek.dao.LibroDAO
import com.danielrodriguez.truequesprestamosgeek.dao.VideojuegoDAO
import com.danielrodriguez.truequesprestamosgeek.model.entities.Producto

class ProductoService{
    private val productos = mutableListOf<Producto>()
    val videojuegoDAO = VideojuegoDAO()
    val libroDAO = LibroDAO()

    fun agregarLibro(titulo: String, descripcion: String, autor: String) {

    }

    fun agregarVideojuego(titulo: String, descripcion: String, plataforma: String) {

    }

    fun listarProductos(filtro:String?): List<Producto>{
        return productos
    }



}