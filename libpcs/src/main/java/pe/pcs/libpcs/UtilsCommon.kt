package pe.pcs.libpcs

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Switch
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import kotlin.system.exitProcess

object UtilsCommon {

    /**
     * Oculta el teclado suave de un elemento de la vista.
     *
     * Esta función oculta el teclado suave que se esté mostrando actualmente en la ventana
     * asociada a la vista especificada.
     *
     * @param context El contexto de la actividad o fragmento.
     * @param view La vista en la que se desea ocultar el teclado.
     * @author Jack Chavez Saravia
     */
    fun hideKeyboard(context: Context, view: View) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    /**
     * Limpia el texto de todos los EditText encontrados dentro de una vista.
     *
     * Esta función itera a través de todos los elementos dentro de la vista
     * proporcionada y verifica si son EditText. Si lo son, limpia su contenido.
     *
     * @param view La vista que contiene los EditText a limpiar.
     * @author Jack Chavez Saravia
     */
    fun cleanEditText(view: View) {
        val it: Iterator<View> = view.touchables.iterator()
        while (it.hasNext()) {
            val v = it.next()
            if (v is EditText) v.setText("")
        }
    }

    /**
     * Limpia el estado de todos los CheckBox encontrados dentro de una vista.
     *
     * Esta función itera a través de todos los elementos dentro de la vista
     * proporcionada y verifica si son CheckBox. Si lo son, desmarca la casilla.
     *
     * @param view La vista que contiene los CheckBox a limpiar.
     * @author Jack Chavez Saravia
     */
    fun cleanCheckBox(view: View) {
        val it: Iterator<View> = view.touchables.iterator()

        while (it.hasNext()) {
            val v = it.next()
            if (v is CheckBox) v.isChecked = false
        }
    }

    /**
     * Limpia el texto de EditText y desmarca CheckBox encontrados dentro de una vista.
     *
     * Esta función itera a través de todos los elementos dentro de la vista
     * proporcionada y verifica si son EditText o CheckBox. Si es un EditText, limpia su contenido.
     * Si es un CheckBox, desmarca la casilla.
     *
     * @param view La vista que contiene los EditText y CheckBox a limpiar.
     * @author Jack Chavez Saravia
     */
    fun cleanEditTextAndCheckBox(view: View) {
        val it: Iterator<View> = view.touchables.iterator()
        while (it.hasNext()) {
            val v = it.next()
            if (v is CheckBox) v.isChecked = false
            if (v is EditText) v.setText("")
        }
    }

    /**
     * Limpia el texto de EditText y desmarca Switch encontrados dentro de una vista.
     *
     * Esta función itera a través de todos los elementos dentro de la vista
     * proporcionada y verifica si son EditText o Switch. Si es un EditText, limpia su contenido.
     * Si es un Switch, desmarca la opción.
     *
     * @param view La vista que contiene los EditText y Switch a limpiar.
     * @author Jack Chavez Saravia
     */
    fun cleanEditTextAndSwitch(view: View) {
        val it: Iterator<View> = view.touchables.iterator()
        while (it.hasNext()) {
            val v = it.next()
            if (v is Switch) v.isChecked = false
            if (v is EditText) v.setText("")
        }
    }

    /**
     * Formatea un valor double a un String con dos decimales.
     *
     * Esta función convierte un valor double a una cadena de texto con dos decimales utilizando
     * el símbolo "." como separador decimal.
     *
     * @param valor El valor double a formatear.
     * @return El String representando el valor double formateado.
     * @author Jack Chavez Saravia
     */
    fun formatFromDoubleToString(valor: Double): String {
        val formato = DecimalFormat("#0.00")

        val dfs = DecimalFormatSymbols()
        dfs.decimalSeparator = '.'

        formato.decimalFormatSymbols = dfs

        return formato.format(valor).toString()
    }

    /**
     * Muestra un cuadro de diálogo de confirmación para cerrar la aplicación.
     *
     * Esta función muestra un cuadro de diálogo con los botones "Aceptar" y "Cancelar" para
     * confirmar si el usuario desea salir de la aplicación. Si el usuario selecciona "Aceptar",
     * se finaliza la actividad actual y se cierra la aplicación.
     *
     * @param context El contexto de la actividad actual.
     * @author Jack Chavez Saravia
     */
    fun closeApp(context: Context) {
        val builder = MaterialAlertDialogBuilder(context)
        builder.setTitle("Confirmacion")
        builder.setMessage("¿Esta seguro de salir de la app?")
        builder.setCancelable(false)
        builder.setPositiveButton("Aceptar") { _: DialogInterface?, _: Int ->
            (context as Activity).finish()
            System.gc()
            exitProcess(0)
        }
        builder.setNegativeButton("Cancelar") { dialog: DialogInterface, _: Int ->
            dialog.cancel()
        }

        builder.create().show()
    }

}