# Libreria de utilidades

La libreria agrupa funcionalidades que se usan frecuentemente en el desarrollo de app, para usarlo debe contar con el sdk de android 7 o superior.

## Requisitos

- Android Studio Koala Feature Drop | 2024.1.2 o superior.
- Android Gradle Plugin Version 8.6.1
- Gradle Version 8.7
- Kotlin 1.9.22 o superior.

## Funcionalidades

- Convertir de numero a letras.
- Mostrar un calendario y mostrar la fecha seleccionada en un EditText.
- Ocultar el teclado.
- Limpiar EditText.
- Limpiar CheckBox.
- Formatear un numero doble a string con dos decimales.
- Cerrar una app.
- Formatear una fecha a string.
- Obtener la fecha actual.
- Obtener la fecha y hora actual.
- Convertir de bytes a image.
- Codificar a base64.
- Decodificar base64.
- Leer mapa de bits desde una vista.
- Redimensionar una imagen.
- Mostrar una alerta.
- Mostrar un toast.
- Crear un hash sha512.
- Permisos en tiempo de ejecución.
- Utilidad de animación (crear transformación).
- Verificar si el dispositivo tiene acceso a una red.
- Valida si una cadena es una dirección IP en formato IPv4.
- Función para agregar ceros a la cadena de entrada hasta completar la longitud especificada.
- Etc.

## Como usarlo

- Primero: Abrir el archivo settings.gradle.kts y agregar la siguiente linea de codigo.
```kotlin
  repositories {
  google()
  mavenCentral()

        // Agregar
        maven { url = uri("https://jitpack.io") }
  }
```

- Segundo: En el archivo libs.versions.toml agregar la version y el nombre de la libreria.
```kotlin
[versions]
    ---
    ---
    libpcsVersion = "1.5.0"

[libraries]
    ---
    ---
    libpcs = { module = "com.github.programadorescs:LibreriaPcs", version.ref = "libpcsVersion" }
```

- Tercero: Abrir el archivo build.gradle.kts a nivel de modulo
```kotlin
  implementation(libs.libpcs)
```

- Cuarto: Sincronizar y listo.

## Pantallazo
![Image text](https://github.com/programadorescs/LibreriaPcs/blob/master/app/src/main/assets/libpcs.png)
