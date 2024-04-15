package pe.pcs.libpcs

import android.util.Base64
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

object UtilsSecurity {

    // Respetar la longitud de la clave a 16 digitos
    private val valor_clave = "Z&K8xD#T@WC=KLQI".toByteArray()

    /**
     * Encripta una cadena de texto utilizando el algoritmo AES.
     *
     * Esta función toma una cadena de texto como entrada y la encripta usando el algoritmo AES.
     * El valor de la clave de encriptación se debe establecer previamente y no se incluye en este método
     * por motivos de seguridad.
     *
     * @param datoSinEncriptar La cadena de texto que se desea encriptar.
     * @return La cadena de texto encriptada en formato Base64.
     * @throws Exception Si ocurre un error durante el proceso de encriptación muestra una excepcion.
     * @author Jack Chavez Saravia
     */
    fun encryptData(datoSinEncriptar: String): String {
        try {
            val cipher = Cipher.getInstance("AES")
            cipher.init(
                Cipher.ENCRYPT_MODE,
                SecretKeySpec(valor_clave, "AES")
            )

            val encriptar = cipher.doFinal(datoSinEncriptar.toByteArray(charset("UTF-8")))

            return Base64.encodeToString(encriptar, Base64.DEFAULT)
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }

    /**
     * Desencripta una cadena de texto encriptada con formato Base64 utilizando el algoritmo AES.
     *
     * Esta función toma una cadena de texto encriptada con formato Base64 como entrada y la desencripta
     * usando el algoritmo AES. El valor de la clave de desencriptación se debe establecer previamente
     * y no se incluye en este método por motivos de seguridad.
     *
     * @param datoEncriptado La cadena de texto encriptada en formato Base64 que se desea desencriptar.
     * @return La cadena de texto desencriptada.
     * @throws Exception Si ocurre un error durante el proceso de desencriptación muestra una excepcion.
     * @author Jack Chavez Saravia
     */
    fun decryptData(datoEncriptado: String): String {
        try {
            val cipher = Cipher.getInstance("AES")
            cipher.init(
                Cipher.DECRYPT_MODE,
                SecretKeySpec(valor_clave, "AES")
            )

            val desencriptado = cipher.doFinal(
                Base64.decode(datoEncriptado.toByteArray(charset("UTF-8")), Base64.DEFAULT)
            )

            return String(desencriptado, charset("UTF-8"))
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }

    /**
     * Genera un hash SHA-512 a partir de una cadena de texto.
     *
     * Esta función toma una cadena de texto como entrada y la convierte en un hash SHA-512 utilizando el algoritmo SHA-512.
     * El hash SHA-512 se representa como una cadena Base64.
     *
     * @param cadena La cadena de texto para la que se desea generar el hash SHA-512.
     * @return La cadena Base64 que representa el hash SHA-512 de la cadena de entrada.
     * @throws RuntimeException Si ocurre un error durante el proceso de generación del hash muestra una excepcion indicando el error.
     * @author Jack Chavez Saravia
     */
    fun createHashSha512(cadena: String): String {
        return try {
            // crear una instancia del algoritmo de hash SHA-512
            val digest = MessageDigest.getInstance("SHA-512")
            // crea una matriz de bytes usando la codificación de caracteres UTF-8
            // y calcula el valor hash SHA-512.
            val hash = digest.digest(cadena.toByteArray(charset("UTF-8")))
            // realiza la codificación en Base64
            Base64.encodeToString(hash, 0).replace("[\n\r]".toRegex(), "")
        } catch (ex: Exception) {
            throw RuntimeException(ex)
        }
    }

}