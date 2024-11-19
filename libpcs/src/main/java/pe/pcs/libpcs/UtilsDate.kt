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

    /**
     * Convierte una cadena de texto que representa una fecha en un objeto Date.
     * La fecha debe estar en el formato "yyyy-MM-dd HH:mm:ss".
     *
     * @param fecha Una cadena de texto que representa la fecha en el formato "yyyy-MM-dd HH:mm:ss".
     * @return Un objeto Date correspondiente a la fecha proporcionada en la cadena.
     * @throws ParseException Si la cadena de entrada no coincide con el formato esperado.
     *
     * ## Ejemplo:
     * ```
     * val fechaString = "2024-11-19 15:30:00"
     * val fecha = convertStringToDate(fechaString)
     * println(fecha)  // Imprime la fecha convertida como objeto Date
     * ```
     * @author Jack Chavez Saravia
     */
    fun convertStringToDate(fecha: String): Date {
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(fecha) ?: throw IllegalArgumentException("Fecha inválida")
    }

    /**
     * Convierte un objeto Date en una cadena de texto representando la fecha en el formato "yyyy-MM-dd HH:mm:ss".
     *
     * @param fecha El objeto Date que se quiere convertir a una cadena de texto.
     * @return Una cadena de texto que representa la fecha en el formato "yyyy-MM-dd HH:mm:ss".
     *
     * ## Ejemplo:
     * ```
     * val fecha = Date()
     * val fechaString = convertDateToString(fecha)
     * println(fechaString)  // Imprime la fecha actual como una cadena
     * ```
     * @author Jack Chavez Saravia
     */
    fun convertDateToString(fecha: Date): String {
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(fecha) ?: throw IllegalArgumentException("Fecha inválida")
    }

    /**
     * Recibe un número entero que representa un mes (del 1 al 12) y devuelve el nombre abreviado del mes en español.
     *
     * @param mes Un número entero entre 1 y 12, representando un mes del año.
     *             1 = Enero, 2 = Febrero, ..., 12 = Diciembre.
     * @return Una cadena de texto con el nombre abreviado del mes en español.
     *         Si el número de mes no está entre 1 y 12, retorna "Desconocido".
     *
     * ## Ejemplo:
     * ```
     * val mes = 3
     * val nombreMes = getMonthName(mes)
     * println(nombreMes)  // Imprime "Mar"
     * ```
     * @author Jack Chavez Saravia
     */
    fun getMonthName(mes: Int): String {
        return when (mes) {
            1 -> "Ene"
            2 -> "Feb"
            3 -> "Mar"
            4 -> "Abr"
            5 -> "May"
            6 -> "Jun"
            7 -> "Jul"
            8 -> "Ago"
            9 -> "Set"
            10 -> "Oct"
            11 -> "Nov"
            12 -> "Dic"
            else -> "Desconocido"
        }
    }

}