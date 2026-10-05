# Registro de Prompts e Inteligencia Artificial Utilizados

En este documento se detallan las instrucciones (prompts) utilizadas con diferentes herramientas de IA para la elaboración del proyecto "Librería".

---

## 1. Generación del Modelo de Clases UML (Mermaid.live)

**Herramienta:** Mermaid.live  
**Prompt:**
classDiagram
    class Libro {
        +String id
        +String titulo
        +String autor
        +String isbn
        +Double precio
        +Int stock
        +aplicarDescuento(porcentaje: Double) Double
        +estaDisponible() Boolean
    }

    class Categoria {
        +String id
        +String nombre
        +String descripcion
        +agregarLibro(libro: Libro) Void
        +obtenerTotalLibros() Int
    }

    class Venta {
        +String idVenta
        +String fecha
        +Double total
        +calcularTotal() Double
        +procesarPago() Boolean
    }

    Categoria "1" o-- "*" Libro : agrupa
    Venta "1" *-- "1..*" Libro : contiene

---

## 2. Generación del Prototipo Visual de Pantallas (Gemini)

**Herramienta:** UX Pilot  
**Prompt:**
> Design a mobile app interface for a Bookstore. 
> Screen 1: A clean catalog showing a list of books with title, author, price, category badge, and a 'View Details' button. 
> Screen 2: A detailed book view with a cover image placeholder, book title, author, ISBN, price, stock availability badge, and an 'Add to Cart' / 'Buy Now' button. Modern Material3 style, clean typography, soft colors.

---

## 3. Generación de Código Kotlin y Jetpack Compose (Gemini en Android Studio)

**Herramienta:** Gemini AI (Android Studio)  
**Prompt:**
> Actúa como un desarrollador experto en Kotlin y Jetpack Compose.
> Necesito que me generes la estructura completa para un proyecto de aplicación de "Librería". 
> 
> Crea el código separado por archivos o secciones claras:
> 
> 1. MODELO DE DATOS (Data Classes):
>    - Libro.kt: id, titulo, autor, isbn, precio, stock y métodos aplicarDescuento(), estaDisponible().
>    - Categoria.kt: id, nombre, descripcion, lista de libros y métodos agregarLibro(), obtenerTotalLibros().
>    - Venta.kt: idVenta, fecha, listaLibros, total y métodos calcularTotal(), procesarPago().
> 
> 2. INTERFAZ GRÁFICA EN JETPACK COMPOSE:
>    - Pantalla 1 (ListaLibrosScreen): TopAppBar "LuminaBooks: Explore", encabezado "Books: All", LazyColumn con tarjetas (Card) que contengan placeholder de imagen, título, autor, precio en Bs., y botón "View Details".
>    - Pantalla 2 (DetalleLibroScreen): TopAppBar con botón "Back", imagen de portada destacada, título en grande, autor, fila con precio "Bs. 120.0" y estado "Stock: 5", y botón "Add to Cart".
> 
> 3. NAVEGACIÓN Y PRUEBA EN MainActivity.kt:
>    - Manejo de estado simple con `mutableStateOf` para conmutar entre pantallas y lista de datos dummy para probar.

