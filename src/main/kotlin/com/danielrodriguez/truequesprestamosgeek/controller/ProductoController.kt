package com.danielrodriguez.truequesprestamosgeek.controller

import com.danielrodriguez.truequesprestamosgeek.model.entities.Producto
import com.danielrodriguez.truequesprestamosgeek.model.entities.Usuario
import com.danielrodriguez.truequesprestamosgeek.service.ProductoService
import com.danielrodriguez.truequesprestamosgeek.utils.errors.FormatoInvalidoException

class ProductoController {
    private val productos = mutableListOf<Producto>()
    private val service = ProductoService()


    fun agregarProducto(titulo: String, descripcion: String, plataforma: String, autor:String, usuario: Usuario) {
        if(titulo.isBlank() || descripcion.isBlank())
            throw FormatoInvalidoException("No pueden haber campos vacíos")
        if (plataforma.isBlank() && autor.isNotBlank())
            service.agregarLibro(titulo, descripcion, autor)
        if(plataforma.isNotBlank() && autor.isBlank())
            service.agregarVideojuego(titulo, descripcion, plataforma)
    }

    fun listarProductos(filtro :String?) {
        productos.addAll(service.listarProductos(filtro))
    }

    fun ficherosCargaProductos(rutaArchivo: String?) {
        println("Función para cargar productos desde ficheros (txt, json).")
        // Lógica para cargar productos desde ficheros
    }

    fun ficherosDescargaProductos(rutaArchivo: String?) {
        println("Función para descargar productos a ficheros (txt, json).")
        // Lógica para descargar productos a ficheros
    }
}