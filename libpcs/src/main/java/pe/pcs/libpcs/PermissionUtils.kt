package pe.pcs.libpcs

import android.app.Activity
import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class PermissionUtils(private val caller: ActivityResultCaller) {

    private var permissionResultCallback: ((Map<String, Boolean>) -> Unit)? = null

    private val requestPermissionLauncher: ActivityResultLauncher<Array<String>> =
        caller.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            permissionResultCallback?.invoke(permissions)
        }

    /**
     * Inicia la solicitud de permisos.
     *
     * @param permissions Lista de permisos que se desean solicitar.
     * @param callback Función que se llama con el resultado de la solicitud de permisos.
     * @author Jack Chavez Saravia
     */
    fun requestPermissions(permissions: Array<String>, callback: (Map<String, Boolean>) -> Unit) {
        permissionResultCallback = callback
        val deniedPermissions = permissions.filter {
            ContextCompat.checkSelfPermission(caller as Activity, it) != PackageManager.PERMISSION_GRANTED
        }.toTypedArray()

        if (deniedPermissions.isNotEmpty()) {
            requestPermissionLauncher.launch(deniedPermissions)
        } else {
            // Todos los permisos ya están concedidos
            callback.invoke(permissions.associateWith { true })
        }
    }

    /**
     * Verifica si se han concedido todos los permisos.
     *
     * @param permissions Lista de permisos a verificar.
     * @return Verdadero si todos los permisos están concedidos, falso en caso contrario.
     * @author Jack Chavez Saravia
     */
    fun arePermissionsGranted(permissions: Array<String>): Boolean {
        return permissions.all {
            ContextCompat.checkSelfPermission(caller as Activity, it) == PackageManager.PERMISSION_GRANTED
        }
    }
}