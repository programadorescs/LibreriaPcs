package pe.pcs.libpcs

import android.content.Context
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder

object UtilsMessage {

    /**
     * Muestra un cuadro de diálogo de alerta simple con un botón de "Aceptar".
     *
     * El título y el mensaje del cuadro de diálogo se pueden personalizar. El cuadro de diálogo
     * no se puede cancelar tocando fuera de él.
     *
     * @param titulo El título del cuadro de diálogo (opcional).
     * @param mensaje El mensaje que se muestra en el cuerpo del cuadro de diálogo.
     * @param contexto El contexto de la actividad o fragmento donde se muestra el cuadro de diálogo.
     * @author Jack Chavez Saravia
     */
    fun showAlertOk(titulo: String?, mensaje: String, contexto: Context) {
        val builder = MaterialAlertDialogBuilder(contexto)
        builder.setMessage(mensaje)
            .setTitle(titulo)
            .setCancelable(false)
            .setPositiveButton("Aceptar") { dialog, _ -> dialog.cancel() }
        builder.create().show()
    }

    /**
     * Muestra un toast con un mensaje personalizado.
     *
     * @param context El contexto de la actividad o fragmento donde se muestra el toast.
     * @param mensaje El texto que se muestra en el toast.
     * @author Jack Chavez Saravia
     */
    fun showToast(context: Context, mensaje: String) {
        Toast.makeText(
            context,
            mensaje,
            Toast.LENGTH_LONG
        ).show()
    }

}