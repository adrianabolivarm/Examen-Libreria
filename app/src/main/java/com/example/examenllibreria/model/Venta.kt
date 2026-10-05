package com.example.examenllibreria.model

data class Venta(
    val idVenta: String,
    val fecha: String,
    val listaLibros: List<Libro>,
    val total: Double
) {
    fun calcularTotal(): Double {
        return listaLibros.sumOf { it.precio }
    }

    fun procesarPago(): Boolean {
        return listaLibros.isNotEmpty() && total > 0.0
    }
}
