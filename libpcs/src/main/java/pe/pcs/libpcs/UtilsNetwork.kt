package pe.pcs.libpcs

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.annotation.RequiresPermission

object UtilsNetwork {

    /**
     * Comprueba si el dispositivo está conectado a una red.
     *
     * Esta función permite verificar si el dispositivo está conectado a una red de internet.
     * NOTA: Necesita tener permisos de ACCESS_NETWORK_STATE para funcionar.
     *
     * @param context Requiere de un contexto.
     * @author Jack Chavez Saravia
     */
    @RequiresPermission(value = "android.permission.ACCESS_NETWORK_STATE")
    fun isInternetAvailable(context: Context): Boolean {
        // Obtiene el Administrador de conectividad
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // Compruebe si el dispositivo está conectado a una red
        val network = connectivityManager.activeNetwork ?: return false
        // Compruebe si la red tiene conexión a Internet.
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false

        // Compruebe si la red tiene las capacidades requeridas
        return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
    }

    /**
     * Valida si una cadena es una dirección IP en formato IPv4.
     *
     * Esta función verifica que la cadena proporcionada tenga el formato correcto de una dirección IP
     * y que cada octeto esté en el rango de 0 a 255.
     *
     * @param ip La cadena que representa la dirección IP a validar.
     * @return true si la cadena es una dirección IP válida, false en caso contrario.
     *
     * La dirección IP se considera válida si:
     * - Tiene el formato 'X.X.X.X', donde X es un número entero de 1 a 3 dígitos.
     * - Cada octeto (X) está en el rango de 0 a 255.
     *
     * Ejemplos:
     * - isValidIp("192.168.1.1") devuelve true
     * - isValidIp("256.100.50.25") devuelve false (el primer octeto es mayor que 255)
     * - isValidIp("192.168.1") devuelve false (no tiene el formato completo)
     *
     * @author Jack Chavez Saravia
     */
    fun isValidIp(ip: String): Boolean {
        val regex = Regex("^(([0-9]{1,3})\\.){3}([0-9]{1,3})?\$")
        return regex.matches(ip) && ip.split(".").all { part ->
            part.toIntOrNull()?.let { it in 0..255 } ?: false
        }
    }

}