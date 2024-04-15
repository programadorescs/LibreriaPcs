package pe.pcs.libpcs

import android.widget.EditText
import androidx.fragment.app.FragmentManager
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

object UtilsDate {

    /**
     * Muestra un selector de fecha con Material Design para elegir una fecha.
     *
     * Esta función muestra un selector de fecha usando Material Design que permite al usuario
     * seleccionar una fecha. La fecha seleccionada se establece en el EditText especificado
     * con el formato "yyyy-MM-dd".
     *
     * @param etFecha El EditText donde se mostrará la fecha seleccionada.
     * @param fragmentManager El FragmentManager necesario para mostrar el selector de fecha.
     * @author Jack Chavez Saravia
     */
    fun mostrarCalendario(etFecha: EditText, fragmentManager: FragmentManager) {
        val picker = MaterialDatePicker.Builder.datePicker().build()
        picker.addOnPositiveButtonClickListener { selection: Long ->
            etFecha.setText(
                SimpleDateFormat("yyyy-MM-dd", Locale.ROOT).format(selection + 86400000L)
            )
        }
        picker.show(fragmentManager, picker.toString())
    }

    /**
     * Formatea una fecha a un String con formato "yyyy-MM-dd".
     *
     * Esta función convierte una instancia de Date a una cadena de texto con el formato "yyyy-MM-dd"
     * utilizando la configuración regional predeterminada del dispositivo.
     *
     * @param fecha La fecha a formatear.
     * @return El String representando la fecha formateada.
     * @author Jack Chavez Saravia
     */
    fun formatearDateToString(fecha: Date): String {
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(fecha)
    }

    /**
     * Muestra el año actual en el EditText especificado.
     *
     * Esta función obtiene el año actual y lo establece en el EditText especificado
     * con el formato "yyyy".
     *
     * @param etFecha El EditText donde se mostrará el año actual.
     * @author Jack Chavez Saravia
     */
    fun mostrarAnioActual(etFecha: EditText) {
        etFecha.setText(
            SimpleDateFormat("yyyy", Locale.ROOT).format(System.currentTimeMillis())
        )
    }

    /**
     * Muestra la fecha actual (año-mes-día) en el EditText especificado.
     *
     * Esta función obtiene la fecha actual y la establece en el EditText especificado
     * con el formato "yyyy-MM-dd".
     *
     * @param etFecha El EditText donde se mostrará la fecha actual.
     * @author Jack Chavez Saravia
     */
    fun mostrarFechaActual(etFecha: EditText) {
        etFecha.setText(
            SimpleDateFormat("yyyy-MM-dd", Locale.ROOT).format(System.currentTimeMillis())
        )
    }

    /**
     * Obtiene la fecha actual (año-mes-día) como un String.
     *
     * Esta función obtiene la fecha actual y la devuelve como una cadena de texto
     * con el formato "yyyy-MM-dd" utilizando la configuración regional predeterminada
     * del dispositivo.
     *
     * @return El String representando la fecha actual.
     * @author Jack Chavez Saravia
     */
    fun obtenerFechaActual(): String {
        return SimpleDateFormat("yyyy-MM-dd", Locale.ROOT).format(System.currentTimeMillis())
    }

    /**
     * Obtiene la fecha y hora actual como un String.
     *
     * Esta función obtiene la fecha y hora actual y la devuelve como una cadena de texto
     * con el formato "yyyy-MM-dd HH:mm:ss" utilizando la configuración regional predeterminada
     * del dispositivo.
     *
     * @return El String representando la fecha y hora actual.
     * @author Jack Chavez Saravia
     */
    fun obtenerFechaHoraActual(): String {
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT).format(System.currentTimeMillis())
    }

}