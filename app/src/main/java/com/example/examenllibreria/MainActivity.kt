package com.example.examenllibreria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.examenllibreria.model.Libro
import com.example.examenllibreria.ui.screens.DetalleLibroScreen
import com.example.examenllibreria.ui.screens.ListaLibrosScreen
import com.example.examenllibreria.ui.theme.ExamenLlibreriaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenLlibreriaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LuminaBooksApp()
                }
            }
        }
    }
}

@Composable
fun LuminaBooksApp() {
    // Estado para alternar entre la lista y el detalle del libro seleccionado
    var libroSeleccionado by remember { mutableStateOf<Libro?>(null) }

    // Datos de prueba dummy con al menos 3 objetos Libro
    val librosDePrueba = remember {
        listOf(
            Libro(
                id = "1",
                titulo = "The Nebula",
                autor = "A. S. Clarke",
                isbn = "978-0123456789",
                precio = 120.0,
                stock = 5
            ),
            Libro(
                id = "2",
                titulo = "Cien Años de Soledad",
                autor = "Gabriel García Márquez",
                isbn = "978-0307474728",
                precio = 150.0,
                stock = 10
            ),
            Libro(
                id = "3",
                titulo = "El Principito",
                autor = "Antoine de Saint-Exupéry",
                isbn = "978-0156013987",
                precio = 85.0,
                stock = 0
            ),
            Libro(
                id = "4",
                titulo = "Don Quijote de la Mancha",
                autor = "Miguel de Cervantes",
                isbn = "978-8424116316",
                precio = 200.0,
                stock = 3
            )
        )
    }

    if (libroSeleccionado == null) {
        ListaLibrosScreen(
            libros = librosDePrueba,
            onSeleccionarLibro = { libro ->
                libroSeleccionado = libro
            }
        )
    } else {
        DetalleLibroScreen(
            libro = libroSeleccionado!!,
            onVolver = {
                libroSeleccionado = null
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LuminaBooksAppPreview() {
    ExamenLlibreriaTheme {
        LuminaBooksApp()
    }
}
