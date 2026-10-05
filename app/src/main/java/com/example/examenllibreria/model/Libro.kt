package com.example.examenllibreria.model

data class Libro(
    val id: String,
    val titulo: String,
    val autor: String,
    val isbn: String,
    val precio: Double,
    val stock: Int
) {
    fun aplicarDescuento(porcentaje: Double): Double {
        val descuento = precio * (porcentaje / 100.0)
        return precio - descuento
    }

    fun estaDisponible(): Boolean {
        return stock > 0
    }
}
