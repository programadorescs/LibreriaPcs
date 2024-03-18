package pe.pcs.libpcs

import android.util.Base64
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

object UtilsSecurity {

    // respetar la longitud de la clave a 16 digitos
    private val valor_clave = "Z&K8xD#T@WC=KLQI".toByteArray()

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