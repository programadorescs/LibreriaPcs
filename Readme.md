# Libreria de utilidades

La libreria agrupa funcionalidades que se usan frecuentemente en el desarrollo de app, para usarlo debe contar con el sdk de android 7 o superior.

## Requisitos

- Android Studio Jellyfish | 2023.3.1 Patch 1 o superior.
- Android Gradle Plugin Version 8.4.1
- Gradle Version 8.6
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
- Mostrar publicidad interstitial de Google AdMob
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
    libpcsVersion = "1.0.7"

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
