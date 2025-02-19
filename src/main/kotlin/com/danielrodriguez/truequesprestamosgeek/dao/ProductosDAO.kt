package com.danielrodriguez.truequesprestamosgeek.dao

import com.danielrodriguez.truequesprestamosgeek.model.entities.Producto

interface ProductosDAO {
    fun agregarProducto(producto: Producto)
    fun listarProductos(): List<Producto>
    fun agregarProductosDesdeArchivo(productos: List<Producto>)
    fun guardarProductosEnArchivo(producto: List<Producto>)

}