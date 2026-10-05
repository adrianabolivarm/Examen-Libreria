package com.example.examenllibreria.model

data class Categoria(
    val id: String,
    val nombre: String,
    val descripcion: String,
    val libros: MutableList<Libro> = mutableListOf()
) {
    fun agregarLibro(libro: Libro) {
        libros.add(libro)
    }

    fun obtenerTotalLibros(): Int {
        return libros.size
    }
}
