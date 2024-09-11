package pe.pcs.libpcs

import android.graphics.Color
import android.view.View
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform

object UtilsAnimation {

    /**
     * Crea una transformación de contenedor material que anima la transición entre dos vistas.
     *
     * Esta función configura una animación de transición entre `vistaInicial` y `vistaFinal` utilizando
     * `MaterialContainerTransform`. La animación tiene una duración configurable y permite establecer
     * un color de fondo para la transición.
     *
     * @param vistaInicial La vista desde la que comienza la animación. Debe ser una vista que tenga
     *                     un layout definido en el XML de la interfaz de usuario.
     * @param vistaFinal La vista hacia la que se realiza la animación. Debe ser una vista que tenga
     *                   un layout definido en el XML de la interfaz de usuario.
     * @param duracion La duración de la animación en milisegundos. Por defecto es 500 milisegundos.
     * @param colorFondoTransicion El color de fondo de la transición. Por defecto es transparente
     *                             (`Color.TRANSPARENT`).
     *
     * @return Una instancia de `MaterialContainerTransform` configurada con las vistas inicial y final,
     *         duración y color de fondo especificados.
     *
     * @author Jack Chavez Saravia
     */
    fun createTransformation(
        vistaInicial: View,
        vistaFinal: View,
        duracion: Long = 500L,
        colorFondoTransicion: Int = Color.TRANSPARENT
    ): MaterialContainerTransform {
        return MaterialContainerTransform().apply {
            scrimColor = colorFondoTransicion
            duration = duracion
            setPathMotion(MaterialArcMotion()) // Ruta de movimiento
            startView = vistaInicial
            endView = vistaFinal
            addTarget(vistaFinal) // Agregamos el objetivo de la animación
        }
    }

}