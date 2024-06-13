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
}